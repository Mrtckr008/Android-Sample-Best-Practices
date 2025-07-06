package com.mrtckr.livecoding.feature.weather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.viewModelScope
import app.cash.turbine.test
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import com.mrtckr.livecoding.domain.usecase.GetWeatherMockDataUseCase
import com.mrtckr.livecoding.feature.weather.widgets.WeatherDataUiState
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class WeatherComposeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getWeatherMockDataUseCase: GetWeatherMockDataUseCase

    private lateinit var viewModel: WeatherComposeViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        whenever(getWeatherMockDataUseCase.invoke(mockWeatherData.cityName)).thenReturn(
            flowOf(
                mockWeatherData
            )
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `weatherState initially Loading`() = runTest {
        viewModel = WeatherComposeViewModel(getWeatherMockDataUseCase)
        assertEquals(WeatherDataUiState.Loading, viewModel.weatherState.value)
    }

    @Test
    fun `weatherState emits Success after update`() = runTest(mainDispatcherRule.dispatcher) {
        viewModel = WeatherComposeViewModel(getWeatherMockDataUseCase)

        viewModel.updateWeatherState(mockWeatherData.cityName)

        runCurrent()

        viewModel.weatherState.test {
            assertEquals(WeatherDataUiState.Success(mockWeatherData), awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
        viewModel.viewModelScope.cancel()
    }
}
