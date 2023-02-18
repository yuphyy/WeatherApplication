package com.example.weatherapplication.data

import com.example.weatherapplication.data.api.WeatherApi
import com.example.weatherapplication.data.api.WeatherResponse
import retrofit2.Response

interface IWeatherRepository {
    suspend fun getWeatherData(city: String): WeatherResponse
}