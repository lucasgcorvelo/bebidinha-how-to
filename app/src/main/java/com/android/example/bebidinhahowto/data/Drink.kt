package com.android.example.bebidinhahowto.data

data class SeachDrinkAPIResult(
    val drinks: List<Drink>
)

data class Drink(
    val idDrink: String? = null,
    val strDrink: String? = null,
    val strInstructions: String? = null,
    val strDrinkThumb: String? = null
)