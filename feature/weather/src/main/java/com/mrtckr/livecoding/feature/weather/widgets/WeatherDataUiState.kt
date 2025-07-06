package com.mrtckr.livecoding.feature.weather.widgets

import com.mrtckr.livecoding.domain.entity.weather.WeatherData

sealed interface WeatherDataUiState {
    data object Loading : WeatherDataUiState

    data class Success(
        val weatherData: WeatherData,
    ) : WeatherDataUiState
}
