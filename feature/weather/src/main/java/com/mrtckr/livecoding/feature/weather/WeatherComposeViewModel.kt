package com.mrtckr.livecoding.feature.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrtckr.livecoding.domain.usecase.GetWeatherMockDataUseCase
import com.mrtckr.livecoding.feature.weather.widgets.WeatherDataUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherComposeViewModel @Inject constructor(
    private val getWeatherMockDataUseCase: GetWeatherMockDataUseCase,
) : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherDataUiState>(WeatherDataUiState.Loading)
    val weatherState: StateFlow<WeatherDataUiState> = _weatherState.asStateFlow()

    fun updateWeatherState(cityName: String) {
        viewModelScope.launch {
            getWeatherMockDataUseCase(cityName)
                .map(WeatherDataUiState::Success)
                .collect { weatherData ->
                    _weatherState.value = weatherData
                }
        }
    }
}
