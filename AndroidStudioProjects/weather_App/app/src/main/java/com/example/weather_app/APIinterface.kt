package com.example.weather_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIinterface {

    @GET("Weather")
    fun getWeatherData(
        @Query("q") city: String,
        @Query("appid") appid: String,
        @Query("units") units: String,
    ) : Call<weather_App>
}