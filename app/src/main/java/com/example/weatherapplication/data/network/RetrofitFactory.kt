package com.example.weatherapplication.data.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object {
        private const val apiUrl = "https://api.openweathermap.org"
        const val apiKey = "a691a9a48e45f01e31a7ab01c1e61a9f"

        fun createRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder().setLenient().create()
                    )
                )
                .build()
        }
    }
}