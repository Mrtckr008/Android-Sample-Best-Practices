package com.mrtckr.livecoding2.ui.compose.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.usecase.GetWeatherByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jetbrains.annotations.VisibleForTesting
import javax.inject.Inject

@HiltViewModel
class HomeComposeViewModel @Inject constructor(
    private val getWeatherByName: GetWeatherByNameUseCase
) : ViewModel() {

    private val _weatherDataData: MutableStateFlow<ResultData<WeatherData>> =
        MutableStateFlow(ResultData.Loading())

    @VisibleForTesting
    internal val weatherData: MutableStateFlow<ResultData<WeatherData>> = _weatherDataData

    private val _capitalWeatherDataData: MutableStateFlow<ResultData<WeatherData>> =
        MutableStateFlow(ResultData.Loading())

    @VisibleForTesting
    internal val capitalWeatherDataData: StateFlow<ResultData<WeatherData>> = _capitalWeatherDataData

    private val _weatherDataDataLiveData: MutableLiveData<ResultData<WeatherData>> = MutableLiveData()

    fun getWeatherData(cityName: String) {
        viewModelScope.launch {
            getWeatherByName(cityName).collect {
                _weatherDataData.value = it
            }
        }
    }

    fun getCapitalWeatherData(name: String) {
        viewModelScope.launch {
            getWeatherByName.invoke(name).collect {
                _capitalWeatherDataData.value = it
            }
        }
    }

    fun getSecondCityWeatherData(name: String) {
        viewModelScope.launch {
            getWeatherByName.invoke(name).collect {
                _weatherDataDataLiveData.postValue(it)
            }
        }
    }
}
