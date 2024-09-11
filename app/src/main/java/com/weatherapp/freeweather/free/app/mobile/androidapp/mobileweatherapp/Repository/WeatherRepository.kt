package com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Repository

import android.os.Build
import androidx.compose.ui.res.stringResource
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Server.ApiServices

class WeatherRepository(val api:ApiServices) {
    fun getCurrentWeather(lat:Double, lng:Double, unit:String)=
        api.getCurrentWeather(lat,lng,unit, "18dd80372f7bb20ff8490aa163cb368b")

    fun getForecastWeather(lat:Double, lng:Double, unit:String)=
        api.getForecastWeather(lat,lng,unit, "18dd80372f7bb20ff8490aa163cb368b")
}