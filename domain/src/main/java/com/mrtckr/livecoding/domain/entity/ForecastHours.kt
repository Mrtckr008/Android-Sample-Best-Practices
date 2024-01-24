package com.mrtckr.livecoding.domain.entity

data class ForecastHours(
    val hour: String,
    val temperature: Int,
    val weatherStatus: WeatherStatus
)