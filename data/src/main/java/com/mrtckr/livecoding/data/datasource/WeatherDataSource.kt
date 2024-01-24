package com.mrtckr.livecoding.data.datasource

import com.mrtckr.livecoding.data.model.WeatherEntity
import com.mrtckr.livecoding.data.retrofit.WeatherService
import com.mrtckr.livecoding.domain.entity.ResultData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherDataSource @Inject constructor(val weatherApi: WeatherService) : IWeatherData {
    override suspend fun getWeatherByName(cityName: String): Flow<ResultData<WeatherEntity>> =
        flow {
            val response = weatherApi.getWeatherByName(cityName)
            if (response.isSuccessful) {
                val weatherEntity = response.body()
                weatherEntity?.let {
                    emit(ResultData.Success(weatherEntity))
                }
            } else {
                emit(ResultData.Error(Exception("Error getting weather data: ${response.code()}")))
            }
        }.catch { exception ->
            when (exception) {
                is IOException -> emit(ResultData.Error(Exception("Network error")))
                is HttpException -> emit(ResultData.Error(Exception("HTTP error: ${exception.code()}")))
                else -> emit(ResultData.Error(Exception("Unknown error")))
            }
        }
}
