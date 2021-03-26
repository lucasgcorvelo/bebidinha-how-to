package com.android.example.bebidinhahowto.features.drinks.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.bebidinhahowto.R
import com.android.example.bebidinhahowto.data.models.Drink
import com.android.example.bebidinhahowto.common.loadImageFromURL
import kotlinx.android.synthetic.main.list_drink.view.*

class DrinkViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_drink, parent, false)) {

    fun bind(drink: Drink) {
        with(itemView) {
            drink_id.text = drink.idDrink
            drink_name.text = drink.strDrink
            drink_instructions.text = drink.strInstructions
            drink.strDrinkThumb?.let { drink_thumb.loadImageFromURL(it) }
        }
    }

}