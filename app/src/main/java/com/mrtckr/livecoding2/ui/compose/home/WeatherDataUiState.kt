package com.mrtckr.livecoding2.ui.compose.home

import com.mrtckr.livecoding.domain.entity.WeatherData

sealed interface WeatherDataUiState {
    data object Loading : WeatherDataUiState

    data class Success(
        val weatherData: WeatherData,
    ) : WeatherDataUiState
}
