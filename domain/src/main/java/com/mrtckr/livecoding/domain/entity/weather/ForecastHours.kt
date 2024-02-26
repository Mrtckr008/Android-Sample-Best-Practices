package com.mrtckr.livecoding.domain.entity.weather

data class ForecastHours(
    val hour: String,
    val temperature: Int,
    val weatherStatus: WeatherStatus
)