package com.mrtckr.livecoding.domain.entity

data class WeatherData(
    val cityName: String,
    val description: String,
    val forecast: List<Forecast>,
    val forecastHours: List<ForecastHours>,
    val temperature: Int,
    val temperatureMax: Int,
    val temperatureMin: Int,
    val uvIndex: UVIndex,
    val rainfallForecast: RainfallForecast,
    val feltTemperature: FeltTemperature,
    val viewingDistance: ViewingDistance
)
