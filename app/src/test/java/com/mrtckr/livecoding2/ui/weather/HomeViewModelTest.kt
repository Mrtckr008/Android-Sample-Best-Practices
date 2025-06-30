package com.mrtckr.livecoding2.ui.weather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.domain.usecase.GetWeatherByNameUseCase
import com.mrtckr.livecoding2.MainDispatcherRule
import com.mrtckr.livecoding2.ui.legacy.home.HomeViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesRule = MainDispatcherRule()

    @Mock
    private lateinit var getWeatherByNameUseCase: GetWeatherByNameUseCase

    @Test
    fun `getWeatherData updates weatherData state correctly on success`() =
        runTest(coroutinesRule.dispatcher) {
            val cityName = "barcelona"
            val expected = ResultData.Success(mockWeatherData)
            val viewModel = HomeViewModel(getWeatherByNameUseCase)

            whenever(getWeatherByNameUseCase.invoke(cityName)).thenReturn(flowOf(expected))

            viewModel.getWeatherData(cityName)

            runCurrent()

            assertEquals(expected, viewModel.weatherData.value)

            viewModel.viewModelScope.cancel()
        }

    @Test
    fun `getWeatherData updates weatherData on error`() = runTest(coroutinesRule.dispatcher) {

        val city = "new york"
        val expected = ResultData.Error(Exception("test error"))

        whenever(getWeatherByNameUseCase.invoke(city)).thenReturn(flowOf(expected))

        val viewModel = HomeViewModel(getWeatherByNameUseCase)

        viewModel.getWeatherData(city)

        runCurrent()

        assertEquals(expected, viewModel.weatherData.value)

        viewModel.viewModelScope.cancel()
    }

    @Test
    fun `getWeatherData sets weatherData as Loading before api call`() {
        val viewModel = HomeViewModel(getWeatherByNameUseCase)
        viewModel.getCapitalWeatherData(mockWeatherData.cityName)
        assertTrue(viewModel.weatherData.value is ResultData.Loading)
        viewModel.viewModelScope.cancel()
    }

    @Test
    fun `combinedWeatherFlow emits correct combined results`() =
        runTest(coroutinesRule.dispatcher) {

            val istanbul = ResultData.Success(mockWeatherData)
            val ankara = ResultData.Success(mockWeatherData.copy(cityName = "Ankara"))

            whenever(getWeatherByNameUseCase.invoke("Istanbul")).thenReturn(flowOf(istanbul))
            whenever(getWeatherByNameUseCase.invoke("Ankara")).thenReturn(flowOf(ankara))

            val vm = HomeViewModel(getWeatherByNameUseCase)

            vm.getWeatherData("Istanbul")
            vm.getCapitalWeatherData("Ankara")

            runCurrent()

            val results = vm.combinedWeatherFlow.take(1).toList()

            assertEquals(listOf(istanbul to ankara), results)

            vm.viewModelScope.cancel()
        }

    @Test
    fun `getSecondCityWeatherData posts weather data to liveData on success`() =
        runTest(coroutinesRule.dispatcher) {

            val expected = ResultData.Success(mockWeatherData)

            whenever(getWeatherByNameUseCase.invoke(mockWeatherData.cityName)).thenReturn(
                flowOf(
                    expected
                )
            )

            val viewModel = HomeViewModel(getWeatherByNameUseCase)

            val observer: Observer<ResultData<WeatherData>> = mock()
            viewModel.weatherDataDataLiveData.observeForever(observer)

            viewModel.getSecondCityWeatherData(mockWeatherData.cityName)

            runCurrent()

            verify(observer).onChanged(expected)

            viewModel.weatherDataDataLiveData.removeObserver(observer)
            viewModel.viewModelScope.cancel()
        }
}
