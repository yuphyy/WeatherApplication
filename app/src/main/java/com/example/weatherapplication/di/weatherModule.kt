package com.example.weatherapplication.di

import com.example.weatherapplication.data.IWeatherRepository
import com.example.weatherapplication.data.network.RetrofitProvider
import com.example.weatherapplication.data.WeatherRepository
import com.example.weatherapplication.data.api.WeatherApi
import com.example.weatherapplication.data.network.createApi
import com.example.weatherapplication.domain.GetWeatherDataUseCase
import com.example.weatherapplication.ui.ToastManager
import com.example.weatherapplication.ui.Weather.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {
    single { RetrofitProvider() }
    single { createApi<WeatherApi>(get()) }
    single<IWeatherRepository> { WeatherRepository(get()) }
    single { GetWeatherDataUseCase(get()) }
    single { ToastManager(get()) }
    viewModel { WeatherViewModel(get(), get()) }
}