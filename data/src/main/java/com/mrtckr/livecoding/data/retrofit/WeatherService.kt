package com.mrtckr.livecoding.data.retrofit

import com.mrtckr.livecoding.data.model.WeatherEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("weather/{cityName}")
    suspend fun getWeatherByName(@Path("cityName") cityName: String): Response<WeatherEntity>
}