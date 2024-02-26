package com.mrtckr.livecoding.domain.usecase

import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import com.mrtckr.livecoding.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherMockDataUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(next: String): Flow<WeatherData> {
        return repository.getWeatherLocalDataByName(next)
    }
}
