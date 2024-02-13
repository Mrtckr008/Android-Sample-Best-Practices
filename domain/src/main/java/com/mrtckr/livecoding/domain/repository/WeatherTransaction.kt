package com.mrtckr.livecoding.domain.repository

import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherTransaction {
    suspend fun getWeatherByName(name: String): Flow<ResultData<WeatherData>>

    fun getWeatherLocalDataByName(name: String): Flow<WeatherData>
}
