package com.example.weatherapplication.data.api

import com.example.weatherapplication.data.RemoteClasses.Main
import com.example.weatherapplication.data.RemoteClasses.Sys
import com.example.weatherapplication.data.RemoteClasses.Weather
import com.example.weatherapplication.data.RemoteClasses.Wind
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("name") val name: String? = null,
    @SerializedName("wind") val wind: Wind? = null,
    @SerializedName("main") val main: Main? = null,
    @SerializedName("sys") val sys: Sys? = null,
    @SerializedName("weather") val weather: List<Weather>? = null,
    val error: String? = null
)