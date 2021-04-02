package com.android.example.bebidinhahowto.features.drinks

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.android.example.bebidinhahowto.R
import com.android.example.bebidinhahowto.data.remote.DrinkService
import com.android.example.bebidinhahowto.features.drinks.components.DrinkAdapter
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

//TODO Organize features into packages
//TODO Create DetailActivity, load the image and show the recipe
//TODO Share recipe with friend by using and exposing menu button on the action bar
//TODO Add the search result into a fragment and show it into the search activity
//TODO Add the register now banner as a fragment under the search details

class SearchDrinkActivity() : AppCompatActivity() {

    private val drinkService: DrinkService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        findViewById<Button>(R.id.search_button).setOnClickListener {
            getDrinks()
        }
    }

    private fun getDrinks() {
        lifecycleScope.launch {
            val input = findViewById<EditText>(R.id.search_text).text.toString()
            val drinks = drinkService.getDrinks(input)
            val drinkRecyclerView = findViewById<RecyclerView>(R.id.drink_list)
            drinkRecyclerView.adapter = DrinkAdapter(drinks)
        }
    }

}