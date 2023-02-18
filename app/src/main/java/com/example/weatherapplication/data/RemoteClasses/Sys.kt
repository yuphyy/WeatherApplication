package com.example.weatherapplication.data.RemoteClasses

import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("sunrise") var sunrise: Long = 0,
    @SerializedName("sunset") var sunset: Long = 0,

)
