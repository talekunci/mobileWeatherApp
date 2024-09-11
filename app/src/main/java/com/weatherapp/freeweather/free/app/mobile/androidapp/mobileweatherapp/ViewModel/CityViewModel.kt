package com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.ViewModel

import androidx.lifecycle.ViewModel
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Repository.CityRepository
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Server.ApiClient
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Server.ApiServices

class CityViewModel(val repository: CityRepository) : ViewModel() {
    constructor() : this(CityRepository(ApiClient().getClient().create(ApiServices::class.java)))

    fun loadCity(q:String,limit:Int)=
        repository.getCities(q,limit)
}