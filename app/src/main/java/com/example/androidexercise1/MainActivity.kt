package com.example.androidexercise1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.androidexercise1.R.layout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val contacts = arrayOf(
            Contact("4 gold", "1234", "4Gold.png"),
            Contact("a teal", "2345", "aTeal.png"),
            Contact("b gold", "3456", "bGold.png"),
            Contact("d black", "4567", "dBlack.png"),
            Contact("e brown", "5678", "eBrown.png"),
            Contact("g pink", "6789", "gPink"),
            Contact("h brown", "1234", "hBrown.png"),
            Contact("i red", "7890", "iRed.png"),
            Contact("n fire", "8901", "nFire.png"),
            Contact("n gold", "9012", "nGold.png"),
            Contact("n metal", "0123", "nMetal.png"),
            Contact("p smile", "1234", "pSmile.png"),
            Contact("r sea", "2345", "rSea.png"),
            Contact("s pink", "3456", "sPink.png"),
            Contact("s red", "4567", "sRed.png"),
            Contact("u gold", "5678", "uGold.png"),
            Contact("u metal", "6789", "uMetal.png"),
            Contact("4 gold + email", "1234", "4Gold.png", "foo@bar"),
            Contact("a teal + email", "2345", "aTeal.png", "foo@bar"),
            Contact("b gold + email", "3456", "bGold.png", "foo@bar"),
            Contact("d black + email", "4567", "dBlack.png", "foo@bar"),
            Contact("e brown + email", "5678", "eBrown.png", "foo@bar"),
            Contact("g pink + email", "6789", "gPink", "foo@bar"),
            Contact("h brown + email", "1234", "hBrown.png", "foo@bar"),
            Contact("i red + email", "7890", "iRed.png", "foo@bar"),
            Contact("n fire + email", "8901", "nFire.png", "foo@bar"),
            Contact("n gold + email", "9012", "nGold.png", "foo@bar"),
            Contact("n metal + email", "0123", "nMetal.png", "foo@bar"),
            Contact("p smile + email", "1234", "pSmile.png", "foo@bar"),
            Contact("r sea + email", "2345", "rSea.png", "foo@bar"),
            Contact("s pink + email", "3456", "sPink.png", "foo@bar"),
            Contact("s red + email", "4567", "sRed.png", "foo@bar"),
            Contact("u gold + email", "5678", "uGold.png", "foo@bar"),
            Contact("u metal + email", "6789", "uMetal.png", "foo@bar"))
        val adapter = ContactsAdapter(contacts,  fun(contact:Contact): Unit {
            val intent = Intent(this, ContactDetailActivity::class.java).apply {
                putExtra("NAME", contact.name)
                putExtra("PHONE", contact.phone)
                putExtra("IMAGE", contact.imageURL)
                if (contact.email != null) {
                    putExtra("EMAIL", contact.email)
                }
            }
            startActivity(intent)
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}