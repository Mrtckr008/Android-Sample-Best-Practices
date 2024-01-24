package com.mrtckr.livecoding.domain.usecase

import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.Weather
import com.mrtckr.livecoding.domain.repository.WeatherTransaction
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class GetWeatherByNameUseCaseTest {

    @Mock
    private lateinit var weatherTransaction: WeatherTransaction

    private lateinit var getWeatherByNameUseCase: GetWeatherByNameUseCase

    @Before
    fun setup() {
        getWeatherByNameUseCase = GetWeatherByNameUseCase(weatherTransaction)
    }

    @Test
    fun `invoke returns success result when repository call is successfully`() = runBlockingTest {
        val cityName = "vienna"
        val expectedResult = ResultData.Success(
            Weather(
                cityName = "vienna",
                description = "cold weather",
                forecast = arrayListOf(),
                temperature = "+2 C",
            )
        )
        `when`(weatherTransaction.getWeatherByName(cityName)).thenReturn(flow { emit(expectedResult) })

        val result: Flow<ResultData<Weather>> = getWeatherByNameUseCase(cityName)

        result.collect { actualResult ->
            assertEquals(expectedResult, actualResult)
        }
    }

    @Test
    fun `invoke returns error result when repository call fails`() = runBlockingTest {
        val cityName = "berlin"
        val expectedResult = ResultData.Error(Exception("Network error"))

        `when`(getWeatherByNameUseCase.invoke(cityName)).thenReturn(flow { emit(expectedResult) })
        val result: Flow<ResultData<Weather>> = getWeatherByNameUseCase.invoke(cityName)

        result.collect { actualResult ->
            assertEquals(actualResult, expectedResult)
        }
    }
}
