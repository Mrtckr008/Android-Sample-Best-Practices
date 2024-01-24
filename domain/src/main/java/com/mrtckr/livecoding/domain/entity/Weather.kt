package com.mrtckr.livecoding.domain.entity

data class Weather(
    val cityName: String,
    val temperature: String,
    val description: String,
    val forecast: List<Forecast>
)
