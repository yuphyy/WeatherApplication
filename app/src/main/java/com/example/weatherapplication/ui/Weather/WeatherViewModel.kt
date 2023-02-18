package com.example.weatherapplication.ui.Weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.R
import com.example.weatherapplication.domain.GetWeatherDataUseCase
import com.example.weatherapplication.ui.ToastManager
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class WeatherViewModel(private val useCase: GetWeatherDataUseCase, private val toastManager: ToastManager): ViewModel() {

    val name = MutableLiveData<String?>("")
    val windSpeed = MutableLiveData<Double?>(0.0)
    val temp = MutableLiveData<Int?>(0)
    val humidity = MutableLiveData<Int?>(0)
    val sunrise = MutableLiveData<Long?>(0)
    val sunset = MutableLiveData<Long?>(0)
    val weather = MutableLiveData<String?>("")
    val city = MutableLiveData<String>("")


    fun getWeather() {
        viewModelScope.launch {
           val response = useCase.getWeatherData(city.value!!)
            if(response.error.isNullOrEmpty()){
                name.value = response.name
                windSpeed.value = response.wind?.speed
                temp.value = response.main?.temp?.minus(273)?.roundToInt()
                humidity.value = response.main?.humidity
                sunrise.value = response.sys?.sunrise?.times(1000)
                sunset.value = response.sys?.sunset?.times(1000)
                weather.value = response.weather?.get(0)?.description
            }
            else{
                toastManager.showToast(R.string.exception)
            }
        }
    }
}