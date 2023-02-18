package com.example.weatherapplication.data.RemoteClasses

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("speed") var speed: Double = 0.0
)
