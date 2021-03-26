package com.android.example.bebidinhahowto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.bebidinhahowto.data.Drink

class DrinkAdapter(private val list: List<Drink>)
    : RecyclerView.Adapter<DrinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DrinkViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink: Drink = list[position]
        holder.bind(drink)
    }

    override fun getItemCount(): Int = list.size

}