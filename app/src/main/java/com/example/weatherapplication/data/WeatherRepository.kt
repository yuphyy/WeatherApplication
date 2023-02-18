package com.example.weatherapplication.data

import com.example.weatherapplication.data.api.WeatherApi
import com.example.weatherapplication.data.api.WeatherResponse
import com.example.weatherapplication.data.network.RetrofitFactory
import java.lang.Exception

class WeatherRepository(private val api: WeatherApi): IWeatherRepository {
    override suspend fun getWeatherData(city: String): WeatherResponse {
        return try{
            val response = api.getWeatherData(city, RetrofitFactory.apiKey)
            if (response.isSuccessful) WeatherResponse(
                name = response.body()?.name,
                wind = response.body()?.wind,
                main = response.body()?.main,
                sys = response.body()?.sys,
                weather = response.body()?.weather
            )
            else WeatherResponse(error = response.errorBody().toString())
        } catch (e: Exception){
            WeatherResponse()
        }
    }
}