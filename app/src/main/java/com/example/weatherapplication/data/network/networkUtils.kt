package com.example.weatherapplication.data.network

internal inline fun <reified T> createApi(retrofitProvider: RetrofitProvider): T {
    return retrofitProvider.get().create(T::class.java)
}