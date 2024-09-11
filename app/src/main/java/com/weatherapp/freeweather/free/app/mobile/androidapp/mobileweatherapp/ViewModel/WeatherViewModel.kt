package com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.ViewModel

import androidx.lifecycle.ViewModel
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Repository.WeatherRepository
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Server.ApiClient
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Server.ApiServices

class WeatherViewModel(val repository: WeatherRepository):ViewModel() {

    constructor():this(WeatherRepository(ApiClient().getClient().create(ApiServices::class.java)))

    fun loadCurrentWeather(lat:Double, lng:Double, unit:String)=
        repository.getCurrentWeather(lat,lng,unit)

    fun loadForecastWeather(lat:Double, lng:Double, unit:String)=
        repository.getForecastWeather(lat,lng,unit)
}