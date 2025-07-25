@file:OptIn(kotlinx.serialization.InternalSerializationApi::class)
package com.mrtckr.livecoding.data.model.weather

import com.mrtckr.livecoding.domain.entity.weather.WeatherStatus
import kotlinx.serialization.Serializable

@Serializable
data class ForecastEntity(
    val day: String,
    val temperatureMax: Int,
    val temperatureMin: Int,
    val weatherStatus: WeatherStatus
)
