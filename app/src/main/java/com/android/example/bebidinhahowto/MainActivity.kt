package com.android.example.bebidinhahowto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.example.bebidinhahowto.features.drinks.SearchDrinkActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, SearchDrinkActivity::class.java)
        startActivity(intent)
    }
}
