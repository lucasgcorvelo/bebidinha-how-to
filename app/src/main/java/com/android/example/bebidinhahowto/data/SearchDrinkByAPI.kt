package com.android.example.bebidinhahowto.data

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class SearchDrinkByAPI(private val listener: TaskListener) :
    AsyncTask<String?, Void?, SeachDrinkAPIResult>() {

    interface TaskListener {
        fun onDrinksResult(drinks: SeachDrinkAPIResult)
    }

    override fun onPostExecute(resultSeachDrink: SeachDrinkAPIResult) {
        listener.onDrinksResult(resultSeachDrink)
    }

    override fun doInBackground(vararg queryString: String?): SeachDrinkAPIResult {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=${queryString[0]}")
            .build()
        val execute = client.newCall(request).execute()
        return parseResponse(execute.body()?.string())
    }

    private fun parseResponse(bodyString: String?): SeachDrinkAPIResult {
        Log.d("bodyString", bodyString.toString())
        return Gson().fromJson(bodyString, SeachDrinkAPIResult::class.java)
    }
}