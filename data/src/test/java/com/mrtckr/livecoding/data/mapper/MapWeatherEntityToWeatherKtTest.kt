package com.mrtckr.livecoding.data.mapper

import com.mrtckr.livecoding.data.model.ForecastEntity
import com.mrtckr.livecoding.data.model.WeatherEntity
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherMappingTest {

    @Test
    fun `mapWeatherEntityToWeather maps correctly`() {
        // Setup
        val forecastEntities = listOf(ForecastEntity(day = "Monday", temperature = "20", wind = "12"))
        val weatherEntity = WeatherEntity(temperature = "15", description = "Sunny", forecast = forecastEntities, wind = "12")

        // Action
        val weather = mapWeatherEntityToWeather(weatherEntity, cityName = "berlin")

        // Assertion
        assertEquals(weatherEntity.temperature, weather.temperature)
        assertEquals(weatherEntity.description, weather.description)
        assertEquals(forecastEntities.size, weather.forecast.size)
        assertEquals(forecastEntities.first().day, weather.forecast.first().day)
        assertEquals(forecastEntities.first().temperature, weather.forecast.first().temperature)
    }
}
