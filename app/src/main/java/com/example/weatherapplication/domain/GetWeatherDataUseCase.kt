package com.example.weatherapplication.domain

import com.example.weatherapplication.data.IWeatherRepository
import com.example.weatherapplication.data.api.WeatherResponse

class GetWeatherDataUseCase(private val repository: IWeatherRepository) {
    suspend fun getWeatherData(city: String): WeatherResponse{
        return repository.getWeatherData(city)
    }
}