package com.mrtckr.livecoding.domain.repository

import com.mrtckr.livecoding.domain.entity.Weather
import kotlinx.coroutines.flow.Flow
import com.mrtckr.livecoding.domain.entity.ResultData

interface WeatherTransaction {
    suspend fun getWeatherByName(name: String): Flow<ResultData<Weather>>
}