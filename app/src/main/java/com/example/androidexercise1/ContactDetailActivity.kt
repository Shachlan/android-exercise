package com.example.androidexercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ContactDetailActivity : AppCompatActivity() {
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
            val emailView = findViewById<TextView>(R.id.Email)
            emailView.setVisibility(View.GONE);
        } else {
            findViewById<TextView>(R.id.Email).apply {
                text = email
            }
        }
    }
}