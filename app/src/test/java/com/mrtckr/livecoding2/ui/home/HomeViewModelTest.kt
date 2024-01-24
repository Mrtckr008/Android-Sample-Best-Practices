package com.mrtckr.livecoding2.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mrtckr.livecoding.data.model.FeltTemperatureEntity
import com.mrtckr.livecoding.data.model.ForecastEntity
import com.mrtckr.livecoding.data.model.ForecastHoursEntity
import com.mrtckr.livecoding.data.model.RainfallForecastEntity
import com.mrtckr.livecoding.data.model.UVIndexEntity
import com.mrtckr.livecoding.data.model.ViewingDistanceEntity
import com.mrtckr.livecoding.data.model.WeatherEntity
import com.mrtckr.livecoding.domain.entity.FeltTemperature
import com.mrtckr.livecoding.domain.entity.Forecast
import com.mrtckr.livecoding.domain.entity.ForecastHours
import com.mrtckr.livecoding.domain.entity.RainfallForecast
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.UVIndex
import com.mrtckr.livecoding.domain.entity.ViewingDistance
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.entity.WeatherStatus
import com.mrtckr.livecoding.domain.usecase.GetWeatherByNameUseCase
import com.mrtckr.livecoding2.MainCoroutineRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesRule = MainCoroutineRule()

    @Mock
    private lateinit var getWeatherByNameUseCase: GetWeatherByNameUseCase

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setup() {
        homeViewModel = HomeViewModel(getWeatherByNameUseCase)
    }

    @Test
    fun `getWeatherData updates weatherData state correctly on success`() = runBlockingTest {
        val cityName = "barcelona"
        val weatherDataResult = ResultData.Success(
            mockWeatherData
        )

        `when`(getWeatherByNameUseCase.invoke(cityName)).thenReturn((flow { emit(weatherDataResult) }))
        homeViewModel.getWeatherData(cityName)

        assertEquals(weatherDataResult, homeViewModel.weatherData.value)
    }

    @Test
    fun `getWeatherData updates weatherData state correctly on error`() = runBlockingTest {
        val cityName = "new york"
        val weatherResult = ResultData.Error(Exception("test error"))

        `when`(getWeatherByNameUseCase.invoke(cityName)).thenReturn(flowOf(weatherResult))
        homeViewModel.getWeatherData(cityName)
        assertEquals(weatherResult, homeViewModel.weatherData.value)
    }

    @Test
    fun `getWeatherData sets weatherData as Loading before api call`() {
        homeViewModel.getCapitalWeatherData("Istanbul")
        assertTrue(homeViewModel.weatherData.value is ResultData.Loading)
    }

    @Test
    fun `combinedWeatherFlow emits correct combined results`() = runBlockingTest {
        val weatherDataResult = ResultData.Success(
            mockWeatherData.copy(cityName = "Istanbul")
        )
        val capitalWeatherResultData = ResultData.Success(
            mockWeatherData.copy(cityName = "Ankara")
        )

        `when`(getWeatherByNameUseCase.invoke("Istanbul")).thenReturn(flowOf(weatherDataResult))
        `when`(getWeatherByNameUseCase.invoke("Ankara")).thenReturn(flowOf(capitalWeatherResultData))

        homeViewModel.getWeatherData("Istanbul")
        homeViewModel.getCapitalWeatherData("Ankara")

        advanceUntilIdle()

        val combinedResults =
            mutableListOf<Pair<ResultData<WeatherData>, ResultData<WeatherData>>>()
        val job = launch {
            homeViewModel.combinedWeatherFlow.toList(combinedResults)
        }

        advanceUntilIdle()
        job.cancel()

        assertTrue(combinedResults.isNotEmpty())
    }

    @Test
    fun `getSecondCityWeatherData posts weather data to liveData on success`() = runBlockingTest {
        val successResult = ResultData.Success(mockWeatherData)

        `when`(getWeatherByNameUseCase.invoke("Istanbul")).thenReturn(flowOf(successResult))

        val observer: Observer<ResultData<WeatherData>> = mock()
        homeViewModel.weatherDataDataLiveData.observeForever(observer)

        homeViewModel.getSecondCityWeatherData("Istanbul")

        verify(observer).onChanged(successResult)

        homeViewModel.weatherDataDataLiveData.removeObserver(observer)
    }
    val mockForecastData = arrayListOf(
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
