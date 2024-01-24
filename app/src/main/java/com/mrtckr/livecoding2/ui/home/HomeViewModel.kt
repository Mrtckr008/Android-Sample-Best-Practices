package com.mrtckr.livecoding2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.Weather
import com.mrtckr.livecoding.domain.usecase.GetWeatherByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import org.jetbrains.annotations.VisibleForTesting
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherByName: GetWeatherByNameUseCase
) : ViewModel() {

    private val _weatherData: MutableStateFlow<ResultData<Weather>> =
        MutableStateFlow(ResultData.Loading())

    @VisibleForTesting
    internal val weatherData: StateFlow<ResultData<Weather>> = _weatherData

    private val _capitalWeatherData: MutableStateFlow<ResultData<Weather>> =
        MutableStateFlow(ResultData.Loading())

    @VisibleForTesting
    internal val capitalWeatherData: StateFlow<ResultData<Weather>> = _capitalWeatherData

    private val _weatherDataLiveData: MutableLiveData<ResultData<Weather>> = MutableLiveData()

    @VisibleForTesting
    internal val weatherDataLiveData: LiveData<ResultData<Weather>> = _weatherDataLiveData

    val combinedWeatherFlow = weatherData.combine(capitalWeatherData) { weather, capitalWeather ->
        Pair(weather, capitalWeather)
    }

    fun getWeatherData(cityName: String) {
        viewModelScope.launch {
            getWeatherByName.invoke(cityName).collect {
                _weatherData.value = it
            }
        }
    }

    fun getCapitalWeatherData(name: String) {
        viewModelScope.launch {
            getWeatherByName.invoke(name).collect {
                _capitalWeatherData.value = it
            }
        }
    }

    fun getSecondCityWeatherData(name: String) {
        viewModelScope.launch {
            getWeatherByName.invoke(name).collect {
                _weatherDataLiveData.postValue(it)
            }
        }
    }
}
