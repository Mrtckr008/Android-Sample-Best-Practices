package com.mrtckr.livecoding.data.datasource.weather

import com.mrtckr.livecoding.data.model.weather.WeatherEntity
import com.mrtckr.livecoding.domain.entity.ResultData
import kotlinx.coroutines.flow.Flow

interface WeatherService {
    suspend fun getWeatherByName(cityName: String): Flow<ResultData<WeatherEntity>>

    suspend fun getWeatherLocalDataByName(cityName: String): WeatherEntity
}
