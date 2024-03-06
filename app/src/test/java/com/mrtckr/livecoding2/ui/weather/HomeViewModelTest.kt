package com.mrtckr.livecoding2.ui.weather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.domain.usecase.GetWeatherByNameUseCase
import com.mrtckr.livecoding2.MainCoroutineRule
import com.mrtckr.livecoding2.ui.legacy.home.HomeViewModel
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
        homeViewModel.getCapitalWeatherData(mockWeatherData.cityName)
        assertTrue(homeViewModel.weatherData.value is ResultData.Loading)
    }

    @Test
    fun `combinedWeatherFlow emits correct combined results`() = runBlockingTest {
        val weatherDataResult = ResultData.Success(
            mockWeatherData.copy(cityName = mockWeatherData.cityName)
        )
        val capitalWeatherResultData = ResultData.Success(
            mockWeatherData.copy(cityName = "Ankara")
        )

        `when`(getWeatherByNameUseCase.invoke(mockWeatherData.cityName)).thenReturn(
            flowOf(
                weatherDataResult
            )
        )
        `when`(getWeatherByNameUseCase.invoke("Ankara")).thenReturn(flowOf(capitalWeatherResultData))

        homeViewModel.getWeatherData(mockWeatherData.cityName)
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

        `when`(getWeatherByNameUseCase.invoke(mockWeatherData.cityName)).thenReturn(
            flowOf(
                successResult
            )
        )

        val observer: Observer<ResultData<WeatherData>> = mock()
        homeViewModel.weatherDataDataLiveData.observeForever(observer)

        homeViewModel.getSecondCityWeatherData(mockWeatherData.cityName)

        verify(observer).onChanged(successResult)

        homeViewModel.weatherDataDataLiveData.removeObserver(observer)
    }
}
