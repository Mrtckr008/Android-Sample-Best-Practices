package com.mrtckr.livecoding.domain.usecase

import com.mrtckr.livecoding.domain.entity.FeltTemperature
import com.mrtckr.livecoding.domain.entity.Forecast
import com.mrtckr.livecoding.domain.entity.ForecastHours
import com.mrtckr.livecoding.domain.entity.RainfallForecast
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.UVIndex
import com.mrtckr.livecoding.domain.entity.ViewingDistance
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.entity.WeatherStatus
import com.mrtckr.livecoding.domain.repository.WeatherRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class GetWeatherByNameUseCaseTestData {

    @Mock
    private lateinit var weatherTransaction: WeatherRepository

    private lateinit var getWeatherByNameUseCase: GetWeatherByNameUseCase

    @Before
    fun setup() {
        getWeatherByNameUseCase = GetWeatherByNameUseCase(weatherTransaction)
    }

    @Test
    fun `invoke returns success result when repository call is successfully`() = runBlockingTest {
        val cityName = "Istanbul"
        val expectedResult = ResultData.Success(
            mockWeatherData
        )
        `when`(weatherTransaction.getWeatherByName(cityName)).thenReturn(flow { emit(expectedResult) })

        val result: Flow<ResultData<WeatherData>> = getWeatherByNameUseCase(cityName)

        result.collect { actualResult ->
            assertEquals(expectedResult, actualResult)
        }
    }

    @Test
    fun `invoke returns error result when repository call fails`() = runBlockingTest {
        val cityName = "berlin"
        val expectedResult = ResultData.Error(Exception("Network error"))

        `when`(getWeatherByNameUseCase.invoke(cityName)).thenReturn(flow { emit(expectedResult) })
        val result: Flow<ResultData<WeatherData>> = getWeatherByNameUseCase.invoke(cityName)

        result.collect { actualResult ->
            assertEquals(actualResult, expectedResult)
        }
    }

    companion object {

        private val mockForecastData = arrayListOf(
            Forecast(
                day = "Today",
                temperatureMax = 12,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.CLOUDY
            ), Forecast(
                day = "Friday",
                temperatureMax = 5,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.SNOWY
            ), Forecast(
                day = "Saturday",
                temperatureMax = 5,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.RAINY
            ), Forecast(
                day = "Sunday",
                temperatureMax = 6,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.CLOUDY
            ), Forecast(
                day = "Monday",
                temperatureMax = 6,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.CLOUDY
            ), Forecast(
                day = "Tuesday",
                temperatureMax = 4,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.SNOWY
            ), Forecast(
                day = "Wednesday",
                temperatureMax = 7,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.RAINY
            ), Forecast(
                day = "Thursday",
                temperatureMax = 10,
                temperatureMin = 3,
                weatherStatus = WeatherStatus.CLOUDY
            ), Forecast(
                day = "Friday",
                temperatureMax = 14,
                temperatureMin = 7,
                weatherStatus = WeatherStatus.SUNNY
            ), Forecast(
                day = "Saturday",
                temperatureMax = 15,
                temperatureMin = 8,
                weatherStatus = WeatherStatus.SUNNY
            ), Forecast(
                day = "Sunday",
                temperatureMax = 10,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.CLOUDY
            ), Forecast(
                day = "Monday",
                temperatureMax = 6,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.RAINY
            ), Forecast(
                day = "Tuesday",
                temperatureMax = 3,
                temperatureMin = -4,
                weatherStatus = WeatherStatus.SNOWY
            ), Forecast(
                day = "Wednesday",
                temperatureMax = -3,
                temperatureMin = -10,
                weatherStatus = WeatherStatus.SNOWY
            ), Forecast(
                day = "Thursday",
                temperatureMax = -2,
                temperatureMin = -9,
                weatherStatus = WeatherStatus.SNOWY
            )
        )

        private val mockForecastHours = arrayListOf(
            ForecastHours(
                hour = "14", temperature = 8, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "15", temperature = 8, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "16", temperature = 7, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "17", temperature = 7, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "18", temperature = 6, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "19", temperature = 5, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "20", temperature = 4, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHours(
                hour = "21", temperature = 4, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHours(
                hour = "22", temperature = 3, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHours(
                hour = "23", temperature = 2, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "00", temperature = 2, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHours(
                hour = "01", temperature = 0, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHours(
                hour = "02", temperature = -1, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHours(
                hour = "03", temperature = -1, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHours(
                hour = "04", temperature = -2, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHours(
                hour = "05", temperature = -3, weatherStatus = WeatherStatus.SNOWY,
            )
        )

        private val mockWeatherData = WeatherData(
            cityName = "Istanbul",
            "Cloudy",
            forecast = mockForecastData,
            temperature = 8,
            temperatureMax = 12,
            temperatureMin = 0,
            uvIndex = UVIndex(
                indexPoint = 0, status = "Low\nFor rest of the day"
            ),
            rainfallForecast = RainfallForecast(
                index = "0 mm",
                description = "In the last 24 hours\nNo rain is expected in the next 10 days."
            ),
            feltTemperature = FeltTemperature(
                degree = 2, description = "The wind feels colder"
            ),
            forecastHours = mockForecastHours,
            viewingDistance = ViewingDistance(
                visibleDistance = "25 km", description = "It's clear now"
            )
        )
    }
}
