package com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Repository

import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Server.ApiServices

class CityRepository (val api:ApiServices){
    fun getCities(q:String, limit:Int)=
        api.getCitiesList(q,limit,"18dd80372f7bb20ff8490aa163cb368b")
}