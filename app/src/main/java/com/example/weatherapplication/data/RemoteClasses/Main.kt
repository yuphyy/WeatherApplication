package com.example.weatherapplication.data.RemoteClasses

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp") var temp: Double = 0.0,
    @SerializedName("humidity") var humidity: Int = 0
)
