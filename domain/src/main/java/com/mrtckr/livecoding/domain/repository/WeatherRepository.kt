package com.mrtckr.livecoding.domain.repository

import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeatherByName(name: String): Flow<ResultData<WeatherData>>

    fun getWeatherLocalDataByName(name: String): Flow<WeatherData>
}
