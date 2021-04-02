package com.android.example.bebidinhahowto

import android.app.Application
import android.util.Log
import com.android.example.bebidinhahowto.data.remote.DrinkService
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DrinkApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initDependencyContainers()
    }

    private fun initDependencyContainers() {

        startKoin {
            modules(apiModule)
        }
    }
}

val apiModule = module {
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(DrinkService::class.java)
    }
}