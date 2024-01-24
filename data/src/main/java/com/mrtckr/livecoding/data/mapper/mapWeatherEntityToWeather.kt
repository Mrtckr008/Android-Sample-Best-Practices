package com.mrtckr.livecoding.data.mapper

import com.mrtckr.livecoding.data.model.ForecastEntity
import com.mrtckr.livecoding.data.model.WeatherEntity
import com.mrtckr.livecoding.domain.entity.Forecast
import com.mrtckr.livecoding.domain.entity.Weather

fun mapWeatherEntityToWeather(weatherEntity: WeatherEntity, cityName: String): Weather {
    return Weather(
        cityName = cityName,
        temperature = weatherEntity.temperature,
        description = weatherEntity.description,
        forecast = weatherEntity.forecast.mapForecastEntityToForecast()
    )
}

fun List<ForecastEntity>.mapForecastEntityToForecast(): List<Forecast> {
    return map { forecastEntity ->
        Forecast(
            day = forecastEntity.day,
            temperature = forecastEntity.temperature
        )
    }
}