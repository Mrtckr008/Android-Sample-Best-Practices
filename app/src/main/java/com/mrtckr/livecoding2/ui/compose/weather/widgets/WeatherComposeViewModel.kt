package com.mrtckr.livecoding2.ui.compose.weather.widgets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrtckr.livecoding.domain.usecase.GetWeatherMockDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WeatherComposeViewModel @Inject constructor(
    private val getWeatherMockDataUseCase: GetWeatherMockDataUseCase,
) : ViewModel() {

    fun getWeatherState(cityName: String): StateFlow<WeatherDataUiState> {
        return getWeatherMockDataUseCase(cityName).map { weatherData ->
                WeatherDataUiState.Success(weatherData)
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = WeatherDataUiState.Loading
            )
    }
}
