package com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Server

import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Model.CityResponseApi
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Model.CurrentResponseApi
import com.weatherapp.freeweather.free.app.mobile.androidapp.mobileweatherapp.Model.ForecastResponsApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("units") units: String,
        @Query("appid") apiKey: String,
    ):Call<CurrentResponseApi>

    @GET("data/2.5/forecast")
    fun getForecastWeather(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("units") units: String,
        @Query("appid") apiKey: String,
    ):Call<ForecastResponsApi>

    @GET("geo/1.0/direct")
    fun getCitiesList(
        @Query("q") q:String,
        @Query("limit") limit:Int,
        @Query("appid")Apikey: String,
    ):Call<CityResponseApi>
}