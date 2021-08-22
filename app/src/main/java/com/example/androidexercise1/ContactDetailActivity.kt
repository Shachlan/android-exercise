package com.example.androidexercise1

import android.content.ContentUris
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


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
                visibility = View.GONE
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
                    continue
                }
                val uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id.toLong())
                findViewById<ImageView>(R.id.imageView).apply {
                    setImageURI(uri)
                }
            }
        }
    }
}