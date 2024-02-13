package com.mrtckr.livecoding.data.model

import com.mrtckr.livecoding.domain.entity.WeatherStatus
import kotlinx.serialization.Serializable

@Serializable
data class ForecastHoursEntity(
    val hour: String,
    val temperature: Int,
    val weatherStatus: WeatherStatus
)
