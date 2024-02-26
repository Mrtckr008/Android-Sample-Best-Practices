package com.mrtckr.livecoding.domain.entity.weather

data class Forecast(
    val day: String,
    val temperatureMax: Int,
    val temperatureMin: Int,
    val weatherStatus: WeatherStatus
)
