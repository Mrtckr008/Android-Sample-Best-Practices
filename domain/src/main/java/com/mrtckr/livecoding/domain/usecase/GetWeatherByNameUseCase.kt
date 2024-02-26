package com.mrtckr.livecoding.domain.usecase

import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import com.mrtckr.livecoding.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherByNameUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(next: String): Flow<ResultData<WeatherData>> {
        return repository.getWeatherByName(next)
    }
}
