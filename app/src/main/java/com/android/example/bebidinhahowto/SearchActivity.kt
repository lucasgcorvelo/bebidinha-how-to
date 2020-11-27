package com.android.example.bebidinhahowto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.example.bebidinhahowto.data.SeachDrinkAPIResult
import com.android.example.bebidinhahowto.data.SearchDrinkByAPI

//TODO Organize features into packages
//TODO Create DetailActivity, load the image and show the recipe
//TODO Share recipe with friend by using and exposing menu button on the action bar
//TODO Add the search result into a fragment and show it into the search activity
//TODO Add the register now banner as a fragment under the search details

class SearchActivity() : AppCompatActivity(), SearchDrinkByAPI.TaskListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        findViewById<Button>(R.id.search_button).setOnClickListener {
            SearchDrinkByAPI(this).execute(findViewById<EditText>(R.id.search_text).text.toString())
        }
    }

    override fun onDrinksResult(drinks: SeachDrinkAPIResult) {
        val drinkRecyclerView = findViewById<RecyclerView>(R.id.drink_list)
        drinkRecyclerView.adapter = DrinkAdapter(drinks.drinks)
    }

}