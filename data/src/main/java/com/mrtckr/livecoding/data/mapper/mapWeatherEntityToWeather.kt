package com.mrtckr.livecoding.data.mapper

import com.mrtckr.livecoding.data.model.ForecastEntity
import com.mrtckr.livecoding.data.model.ForecastHoursEntity
import com.mrtckr.livecoding.data.model.WeatherEntity
import com.mrtckr.livecoding.domain.entity.FeltTemperature
import com.mrtckr.livecoding.domain.entity.Forecast
import com.mrtckr.livecoding.domain.entity.ForecastHours
import com.mrtckr.livecoding.domain.entity.RainfallForecast
import com.mrtckr.livecoding.domain.entity.UVIndex
import com.mrtckr.livecoding.domain.entity.ViewingDistance
import com.mrtckr.livecoding.domain.entity.WeatherData

fun mapWeatherEntityToWeather(weatherEntity: WeatherEntity, cityName: String): WeatherData {
    return WeatherData(
        cityName = cityName,
        temperature = weatherEntity.temperature,
        temperatureMin = weatherEntity.temperatureMin,
        temperatureMax = weatherEntity.temperatureMax,
        description = weatherEntity.description,
        viewingDistance = ViewingDistance(
            visibleDistance = weatherEntity.viewingDistance.visibleDistance,
            description = weatherEntity.viewingDistance.description
        ),
        rainfallForecast = RainfallForecast(
            index = weatherEntity.rainfallForecast.index, description = weatherEntity.rainfallForecast.description
        ),
        feltTemperature = FeltTemperature(
            degree = weatherEntity.feltTemperature.degree,
            description = weatherEntity.feltTemperature.description
        ),
        uvIndex = UVIndex(
            indexPoint = weatherEntity.uvIndex.indexPoint, status = weatherEntity.uvIndex.status
        ),
        forecastHours = weatherEntity.forecastHours.mapForecastHourEntityToForecast(),
        forecast = weatherEntity.forecast.mapForecastEntityToForecast()
    )
}

fun List<ForecastEntity>.mapForecastEntityToForecast(): List<Forecast> {
    return map { forecastEntity ->
        Forecast(
            day = forecastEntity.day,
            temperatureMax = forecastEntity.temperatureMax,
            temperatureMin = forecastEntity.temperatureMin,
            weatherStatus = forecastEntity.weatherStatus
        )
    }
}

fun List<ForecastHoursEntity>.mapForecastHourEntityToForecast(): List<ForecastHours> {
    return map { forecastEntity ->
        ForecastHours(
            hour = forecastEntity.hour,
            temperature = forecastEntity.temperature,
            weatherStatus = forecastEntity.weatherStatus
        )
    }
}