package com.mrtckr.livecoding2.ui.compose.weather.widgets

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.domain.usecase.GetWeatherMockDataUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class WeatherComposeViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getWeatherMockDataUseCase: GetWeatherMockDataUseCase

    private lateinit var viewModel: WeatherComposeViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = WeatherComposeViewModel(getWeatherMockDataUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getWeatherState emits Success state with correct data`() = runTest {
        val cityName = "Istanbul"
        val mockWeatherData = mockWeatherData

        `when`(getWeatherMockDataUseCase(cityName)).thenReturn(flow { emit(mockWeatherData) })

        val weatherStateFlow = viewModel.getWeatherState(cityName)

        weatherStateFlow.test {
            val emission = awaitItem()
            assert(emission is WeatherDataUiState.Success && emission.weatherData == mockWeatherData)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `getWeatherState emits Loading state initially`() = runTest {
        assertEquals(WeatherDataUiState.Loading, viewModel.getWeatherState("Barcelona").value)
    }
}
