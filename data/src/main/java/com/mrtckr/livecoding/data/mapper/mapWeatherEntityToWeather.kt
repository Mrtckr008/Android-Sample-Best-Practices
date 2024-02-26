package com.mrtckr.livecoding.data.mapper

import com.mrtckr.livecoding.data.model.weather.ForecastEntity
import com.mrtckr.livecoding.data.model.weather.ForecastHoursEntity
import com.mrtckr.livecoding.data.model.weather.WeatherEntity
import com.mrtckr.livecoding.domain.entity.weather.FeltTemperature
import com.mrtckr.livecoding.domain.entity.weather.Forecast
import com.mrtckr.livecoding.domain.entity.weather.ForecastHours
import com.mrtckr.livecoding.domain.entity.weather.RainfallForecast
import com.mrtckr.livecoding.domain.entity.weather.UVIndex
import com.mrtckr.livecoding.domain.entity.weather.ViewingDistance
import com.mrtckr.livecoding.domain.entity.weather.WeatherData

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
            index = weatherEntity.rainfallForecast.index,
            description = weatherEntity.rainfallForecast.description
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
