package com.mrtckr.livecoding.data.model.weather

import kotlinx.serialization.Serializable

@Serializable
data class WeatherEntity(
    val description: String,
    val forecast: List<ForecastEntity>,
    val forecastHours: List<ForecastHoursEntity>,
    val temperature: Int,
    val temperatureMax: Int,
    val temperatureMin: Int,
    val uvIndex: UVIndexEntity,
    val rainfallForecast: RainfallForecastEntity,
    val feltTemperature: FeltTemperatureEntity,
    val viewingDistance: ViewingDistanceEntity
)
