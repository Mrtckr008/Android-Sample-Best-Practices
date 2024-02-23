package com.mrtckr.livecoding.data.datasourceimpl

import com.mrtckr.livecoding.data.WeatherDataSourceImpl
import com.mrtckr.livecoding.data.datasource.WeatherService
import com.mrtckr.livecoding.data.model.weather.FeltTemperatureEntity
import com.mrtckr.livecoding.data.model.weather.ForecastEntity
import com.mrtckr.livecoding.data.model.weather.ForecastHoursEntity
import com.mrtckr.livecoding.data.model.weather.RainfallForecastEntity
import com.mrtckr.livecoding.data.model.weather.UVIndexEntity
import com.mrtckr.livecoding.data.model.weather.ViewingDistanceEntity
import com.mrtckr.livecoding.data.model.weather.WeatherEntity
import com.mrtckr.livecoding.data.testing.mockWeatherData
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.entity.WeatherStatus
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@ExperimentalCoroutinesApi
class WeatherDataSourceImplTest {
    private lateinit var weatherDataSource: WeatherDataSourceImpl
    private val mockWeatherService: WeatherService = mock()
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        weatherDataSource = WeatherDataSourceImpl(
            iWeatherData = mockWeatherService, ioDispatcher = testDispatcher
        )
    }

    @Test
    fun `getWeatherByName should return mapped WeatherData on success`() = runTest(testDispatcher) {
        val cityName = "Test City"
        val weatherEntity = mockWeatherData
        val expectedWeatherData = mockWeatherDomainData

        `when`(mockWeatherService.getWeatherByName(cityName)).thenReturn(
            flowOf(
                ResultData.Success(
                    weatherEntity
                )
            )
        )

        val resultFlow: Flow<ResultData<WeatherData>> = weatherDataSource.getWeatherByName(cityName)

        resultFlow.collect { result ->
            when (result) {
                is ResultData.Success -> {
                    assertEquals(expectedWeatherData.temperature, result.data.temperature)
                    assertEquals(expectedWeatherData.description, result.data.description)
                    assertEquals(expectedWeatherData.temperatureMin, result.data.temperatureMin)
                }

                else -> throw AssertionError("Expected ResultData.Success")
            }
        }
    }

    @Test
    fun `getWeatherByName should return error on failure`() = runTest(testDispatcher) {
        val cityName = "Test City"
        val exception = RuntimeException("Test error")

        `when`(mockWeatherService.getWeatherByName(cityName)).thenReturn(
            flowOf(
                ResultData.Error(
                    exception
                )
            )
        )

        val resultFlow: Flow<ResultData<WeatherData>> = weatherDataSource.getWeatherByName(cityName)

        resultFlow.collect { result ->
            when (result) {
                is ResultData.Error -> assertEquals(exception, result.exception)
                else -> throw AssertionError("Expected ResultData.Error")
            }
        }
    }

    companion object {
        val mockForecastData = arrayListOf(
            ForecastEntity(
                day = "Today",
                temperatureMax = 12,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.CLOUDY
            ), ForecastEntity(
                day = "Friday",
                temperatureMax = 5,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.SNOWY
            ), ForecastEntity(
                day = "Saturday",
                temperatureMax = 5,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.RAINY
            ), ForecastEntity(
                day = "Sunday",
                temperatureMax = 6,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.CLOUDY
            ), ForecastEntity(
                day = "Monday",
                temperatureMax = 6,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.CLOUDY
            ), ForecastEntity(
                day = "Tuesday",
                temperatureMax = 4,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.SNOWY
            ), ForecastEntity(
                day = "Wednesday",
                temperatureMax = 7,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.RAINY
            ), ForecastEntity(
                day = "Thursday",
                temperatureMax = 10,
                temperatureMin = 3,
                weatherStatus = WeatherStatus.CLOUDY
            ), ForecastEntity(
                day = "Friday",
                temperatureMax = 14,
                temperatureMin = 7,
                weatherStatus = WeatherStatus.SUNNY
            ), ForecastEntity(
                day = "Saturday",
                temperatureMax = 15,
                temperatureMin = 8,
                weatherStatus = WeatherStatus.SUNNY
            ), ForecastEntity(
                day = "Sunday",
                temperatureMax = 10,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.CLOUDY
            ), ForecastEntity(
                day = "Monday",
                temperatureMax = 6,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.RAINY
            ), ForecastEntity(
                day = "Tuesday",
                temperatureMax = 3,
                temperatureMin = -4,
                weatherStatus = WeatherStatus.SNOWY
            ), ForecastEntity(
                day = "Wednesday",
                temperatureMax = -3,
                temperatureMin = -10,
                weatherStatus = WeatherStatus.SNOWY
            ), ForecastEntity(
                day = "Thursday",
                temperatureMax = -2,
                temperatureMin = -9,
                weatherStatus = WeatherStatus.SNOWY
            )
        )

        private val mockForecastHours = arrayListOf(
            ForecastHoursEntity(
                hour = "14", temperature = 8, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "15", temperature = 8, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "16", temperature = 7, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "17", temperature = 7, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "18", temperature = 6, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "19", temperature = 5, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "20", temperature = 4, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHoursEntity(
                hour = "21", temperature = 4, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHoursEntity(
                hour = "22", temperature = 3, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHoursEntity(
                hour = "23", temperature = 2, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "00", temperature = 2, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "01", temperature = 0, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHoursEntity(
                hour = "02", temperature = -1, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHoursEntity(
                hour = "03", temperature = -1, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHoursEntity(
                hour = "04", temperature = -2, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHoursEntity(
                hour = "05", temperature = -3, weatherStatus = WeatherStatus.SNOWY,
            )
        )

        val mockWeatherDomainData = WeatherEntity(
            "Cloudy",
            forecast = mockForecastData,
            temperature = 8,
            temperatureMax = 12,
            temperatureMin = 0,
            uvIndex = UVIndexEntity(
                indexPoint = 0, status = "Low\nFor rest of the day"
            ),
            rainfallForecast = RainfallForecastEntity(
                index = "0 mm",
                description = "In the last 24 hours\nNo rain is expected in the next 10 days."
            ),
            feltTemperature = FeltTemperatureEntity(
                degree = 2, description = "The wind feels colder"
            ),
            forecastHours = mockForecastHours,
            viewingDistance = ViewingDistanceEntity(
                visibleDistance = "25 km", description = "It's clear now"
            )
        )
    }
}
