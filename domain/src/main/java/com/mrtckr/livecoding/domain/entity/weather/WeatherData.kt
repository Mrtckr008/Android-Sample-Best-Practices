package com.mrtckr.livecoding.domain.entity.weather

import com.mrtckr.livecoding.domain.entity.weather.FeltTemperature
import com.mrtckr.livecoding.domain.entity.weather.Forecast
import com.mrtckr.livecoding.domain.entity.weather.ForecastHours
import com.mrtckr.livecoding.domain.entity.weather.RainfallForecast
import com.mrtckr.livecoding.domain.entity.weather.UVIndex
import com.mrtckr.livecoding.domain.entity.weather.ViewingDistance

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
