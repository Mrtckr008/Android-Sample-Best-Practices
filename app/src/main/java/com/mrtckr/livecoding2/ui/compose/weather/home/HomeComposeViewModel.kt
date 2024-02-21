package com.mrtckr.livecoding2.ui.compose.weather.home

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
class HomeComposeViewModel @Inject constructor(
    getWeatherMockDataUseCase: GetWeatherMockDataUseCase,
) : ViewModel() {

    val weatherState: StateFlow<WeatherDataUiState> =
        getWeatherMockDataUseCase("Istanbul").map(WeatherDataUiState::Success).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = WeatherDataUiState.Loading
        )
}
