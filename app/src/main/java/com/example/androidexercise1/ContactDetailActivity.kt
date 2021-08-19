package com.example.androidexercise1

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.R.attr.path

import android.R.string
import android.content.ContentUris
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.io.File
import kotlin.math.log


class ContactDetailActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        // Capture the layout's TextView and set the string as its text
        findViewById<TextView>(R.id.Name).apply {
            text = intent.getStringExtra("NAME")
        }
       findViewById<TextView>(R.id.Phone).apply {
            text = intent.getStringExtra("PHONE")
        }

        val email = intent.getStringExtra("EMAIL")
        if (email == null) {
            findViewById<TextView>(R.id.Email).apply {
                visibility = View.GONE;
            }
        } else {
            findViewById<TextView>(R.id.Email).apply {
                text = email
            }
        }

        val projection = arrayOf(MediaStore.Images.Media._ID, MediaStore.Images.Media.DISPLAY_NAME)
        val selection = ""
        val selectionArgs = arrayListOf<String>()
        val sortOrder = "${MediaStore.Images.Media.DISPLAY_NAME} ASC"
        Log.e("",selection)
        applicationContext.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            selectionArgs.toTypedArray(),
            sortOrder
        )?.use { cursor ->
            val nameColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            while (cursor.moveToNext()) {
                val name = cursor.getString(nameColumn)
                val id = cursor.getString(idColumn)
                if (name != intent.getStringExtra("IMAGE")) {
                    Log.w("not", name)
                    continue;
                }
                Log.e("found", name)
                Log.e("found", id)
                val uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id.toLong())
                findViewById<ImageView>(R.id.imageView).apply {
                    setImageURI(uri)
                }
            }
        }
    }
}