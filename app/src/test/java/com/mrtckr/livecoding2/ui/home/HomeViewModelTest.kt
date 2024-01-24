package com.mrtckr.livecoding2.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.Weather
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
        val weatherResult = ResultData.Success(
            Weather(
                cityName = "istanbul",
                temperature = "+8 C",
                description = "Cold",
                forecast = arrayListOf(),
            )
        )

        `when`(getWeatherByNameUseCase.invoke(cityName)).thenReturn((flow { emit(weatherResult) }))
        homeViewModel.getWeatherData(cityName)

        assertEquals(weatherResult, homeViewModel.weatherData.value)
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
        homeViewModel.getCapitalWeatherData("berlin")
        assertTrue(homeViewModel.weatherData.value is ResultData.Loading)
    }

    @Test
    fun `combinedWeatherFlow emits correct combined results`() = runBlockingTest {
        val weatherResult = ResultData.Success(
            Weather(
                cityName = "istanbul",
                temperature = "+8 C",
                description = "Sunny",
                forecast = listOf()
            )
        )
        val capitalWeatherResult = ResultData.Success(
            Weather(
                cityName = "ankara",
                temperature = "+15 C",
                description = "Cloudy",
                forecast = listOf()
            )
        )

        `when`(getWeatherByNameUseCase.invoke("istanbul")).thenReturn(flowOf(weatherResult))
        `when`(getWeatherByNameUseCase.invoke("ankara")).thenReturn(flowOf(capitalWeatherResult))

        homeViewModel.getWeatherData("istanbul")
        homeViewModel.getCapitalWeatherData("ankara")

        advanceUntilIdle()

        val combinedResults = mutableListOf<Pair<ResultData<Weather>, ResultData<Weather>>>()
        val job = launch {
            homeViewModel.combinedWeatherFlow.toList(combinedResults)
        }

        advanceUntilIdle()
        job.cancel()

        assertTrue(combinedResults.isNotEmpty())
    }

    @Test
    fun `getSecondCityWeatherData posts weather data to liveData on success`() = runBlockingTest {

        val weatherData = Weather(
            cityName = "Test City",
            temperature = "10°C",
            description = "Sunny",
            forecast = listOf()
        )
        val successResult = ResultData.Success(weatherData)

        `when`(getWeatherByNameUseCase.invoke("Test City")).thenReturn(flowOf(successResult))

        val observer: Observer<ResultData<Weather>> = mock()
        homeViewModel.weatherDataLiveData.observeForever(observer)

        homeViewModel.getSecondCityWeatherData("Test City")

        verify(observer).onChanged(successResult)

        homeViewModel.weatherDataLiveData.removeObserver(observer)
    }
}
