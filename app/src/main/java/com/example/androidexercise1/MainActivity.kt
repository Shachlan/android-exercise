package com.example.androidexercise1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, ContactDetailActivity::class.java).apply {
            putExtra("NAME", "Shachar");
            putExtra("PHONE", "0000")
            putExtra("EMAIL", "YO@Lo.com")
        }
        startActivity(intent)
    }
}