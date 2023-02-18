package com.example.weatherapplication.data.network

import retrofit2.Retrofit

class RetrofitProvider() {
    fun get(): Retrofit = RetrofitFactory.createRetrofit()
}