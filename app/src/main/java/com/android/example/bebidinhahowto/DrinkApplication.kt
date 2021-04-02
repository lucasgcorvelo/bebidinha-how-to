package com.android.example.bebidinhahowto

import android.app.Application
import android.util.Log
import com.android.example.bebidinhahowto.data.remote.DrinkService
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit


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
        Log.i("Koin", "Get Api")
        val retrofit = Retrofit.Builder()
           //.baseUrl("https://api.github.com/")
            .build()

        retrofit.create(DrinkService::class.java)
    }
}