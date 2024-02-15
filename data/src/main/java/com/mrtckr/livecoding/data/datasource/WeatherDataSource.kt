package com.mrtckr.livecoding.data.datasource

import com.mrtckr.common.network.AppDispatchers
import com.mrtckr.common.network.Dispatcher
import com.mrtckr.livecoding.data.model.WeatherEntity
import com.mrtckr.livecoding.data.retrofit.WeatherService
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.network.JvmUnitTestFakeAssetManager
import com.mrtckr.network.fake.FakeAssetManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherDataSource @Inject constructor(
    private val weatherApi: WeatherService,
    private val networkJson: Json,
    private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : IWeatherData {

    override suspend fun getWeatherByName(cityName: String): Flow<ResultData<WeatherEntity>> =
        flow {
            val response = weatherApi.getWeatherByName(cityName)
            if (response.isSuccessful) {
                val weatherEntity = response.body()
                weatherEntity?.let {
                    emit(ResultData.Success(it))
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

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getWeatherLocalDataByName(cityName: String): WeatherEntity =
        withContext(ioDispatcher) {
            assets.open(WEATHER_DATA).use(networkJson::decodeFromStream)
        }

    companion object {
        private const val WEATHER_DATA = "weather_data.json"
    }
}
