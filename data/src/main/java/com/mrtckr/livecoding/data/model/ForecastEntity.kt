package com.mrtckr.livecoding.data.model

import com.mrtckr.livecoding.domain.entity.WeatherStatus

data class ForecastEntity(
    val day: String,
    val temperatureMax: Int,
    val temperatureMin: Int,
    val weatherStatus: WeatherStatus
)
