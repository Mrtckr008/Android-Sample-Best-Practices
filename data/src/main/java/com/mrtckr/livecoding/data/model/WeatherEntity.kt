package com.mrtckr.livecoding.data.model

data class WeatherEntity(
    val description: String,
    val forecast: List<ForecastEntity>,
    val temperature: String,
    val wind: String
)
