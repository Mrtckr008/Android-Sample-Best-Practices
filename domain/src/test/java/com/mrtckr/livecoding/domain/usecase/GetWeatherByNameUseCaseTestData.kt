package com.mrtckr.livecoding.domain.usecase

import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.repository.WeatherRepository
import com.mrtckr.livecoding.domain.testing.mockWeatherData
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class GetWeatherByNameUseCaseTestData {

    @Mock
    private lateinit var weatherTransaction: WeatherRepository

    private lateinit var getWeatherByNameUseCase: GetWeatherByNameUseCase

    @Before
    fun setup() {
        getWeatherByNameUseCase = GetWeatherByNameUseCase(weatherTransaction)
    }

    @Test
    fun `invoke returns success result when repository call is successfully`() = runTest {
        val cityName = "Istanbul"
        val expectedResult = ResultData.Success(
            mockWeatherData
        )
        `when`(weatherTransaction.getWeatherByName(cityName)).thenReturn(flow { emit(expectedResult) })

        val result: Flow<ResultData<WeatherData>> = getWeatherByNameUseCase(cityName)

        result.collect { actualResult ->
            assertEquals(expectedResult, actualResult)
        }
    }

    @Test
    fun `invoke returns error result when repository call fails`() = runTest {
        val cityName = "berlin"
        val expectedResult = ResultData.Error(Exception("Network error"))

        `when`(getWeatherByNameUseCase.invoke(cityName)).thenReturn(flow { emit(expectedResult) })
        val result: Flow<ResultData<WeatherData>> = getWeatherByNameUseCase.invoke(cityName)

        result.collect { actualResult ->
            assertEquals(actualResult, expectedResult)
        }
    }
}
