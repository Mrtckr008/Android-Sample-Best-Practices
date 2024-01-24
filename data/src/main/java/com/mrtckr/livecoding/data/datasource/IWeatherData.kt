package com.mrtckr.livecoding.data.datasource

import com.mrtckr.livecoding.data.model.WeatherEntity
import com.mrtckr.livecoding.domain.entity.ResultData
import kotlinx.coroutines.flow.Flow

interface IWeatherData {
    suspend fun getWeatherByName(cityName: String): Flow<ResultData<WeatherEntity>>
}
