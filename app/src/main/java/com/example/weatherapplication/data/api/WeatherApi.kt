package com.example.weatherapplication.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
    @GET("data/2.5/weather?")
    suspend fun getWeatherData(@Query("q") lat: String, @Query("APPID") appId: String): Response<WeatherResponse>
}