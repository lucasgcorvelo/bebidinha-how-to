package com.android.example.bebidinhahowto.data.remote

import com.android.example.bebidinhahowto.data.models.Drink
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkService {
    @GET("https://www.thecocktaildb.com/api/json/v1/1/search.php")
    suspend fun getDrinks(@Query("s") input: String): DrinkResult
}

data class DrinkResult(val drinks: List<Drink>)