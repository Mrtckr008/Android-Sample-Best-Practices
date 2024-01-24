package com.mrtckr.livecoding.data.model

import com.mrtckr.livecoding.domain.entity.WeatherStatus

data class ForecastHoursEntity(
    val hour: String,
    val temperature: Int,
    val weatherStatus: WeatherStatus
)
