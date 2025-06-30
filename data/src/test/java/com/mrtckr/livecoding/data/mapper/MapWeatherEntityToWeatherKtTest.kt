package com.mrtckr.livecoding.data.mapper


import com.mrtckr.livecoding.data.testing.mockForecastData
import com.mrtckr.livecoding.data.testing.mockWeatherData
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherDataMappingTest {

    @Test
    fun `mapWeatherEntityToWeather maps correctly`() {
        val forecastEntities = mockForecastData
        val weatherEntity = mockWeatherData

        val weather = mapWeatherEntityToWeather(
            weatherEntity, cityName = com.mrtckr.livecoding.domain.testing.mockWeatherData.cityName
        )

        assertEquals(weatherEntity.temperature, weather.temperature)
        assertEquals(weatherEntity.description, weather.description)
        assertEquals(forecastEntities.size, weather.forecast.size)
        assertEquals(forecastEntities.first().day, weather.forecast.first().day)
        assertEquals(
            forecastEntities.first().temperatureMin, weather.forecast.first().temperatureMin
        )
    }
}
