package com.mrtckr.livecoding.data

import com.mrtckr.common.network.AppDispatchers
import com.mrtckr.common.network.Dispatcher
import com.mrtckr.livecoding.data.datasource.IWeatherData
import com.mrtckr.livecoding.data.mapper.mapWeatherEntityToWeather
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.repository.WeatherTransaction
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherDataSourceImpl @Inject constructor(
    private val iWeatherData: IWeatherData,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : WeatherTransaction {
    override suspend fun getWeatherByName(name: String): Flow<ResultData<WeatherData>> {
        return iWeatherData.getWeatherByName(name).map { resultData ->
            when (resultData) {
                is ResultData.Success -> ResultData.Success(
                    mapWeatherEntityToWeather(
                        resultData.data, name
                    )
                )

                is ResultData.Error -> ResultData.Error(resultData.exception)
                is ResultData.Loading -> ResultData.Loading()
            }
        }.flowOn(ioDispatcher)
    }

    override fun getWeatherLocalDataByName(name: String): Flow<WeatherData> = flow {
        emit(
            mapWeatherEntityToWeather(
                iWeatherData.getWeatherLocalDataByName(name), name
            )
        )
    }.flowOn(ioDispatcher)
}
