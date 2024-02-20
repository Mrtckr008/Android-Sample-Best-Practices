package com.mrtckr.livecoding.domain.usecase

import com.mrtckr.livecoding.domain.entity.WeatherData
import com.mrtckr.livecoding.domain.entity.user.User
import com.mrtckr.livecoding.domain.repository.WeatherRepository
import com.mrtckr.livecoding.domain.usecase.GetWeatherByNameUseCaseTestData.Companion.mockWeatherData
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class GetWeatherMockDataUseCaseTestData {

    @Mock
    private lateinit var weatherTransaction: WeatherRepository

    private lateinit var getWeatherMockDataUseCase: GetWeatherMockDataUseCase

    @Before
    fun setup() {
        getWeatherMockDataUseCase = GetWeatherMockDataUseCase(weatherTransaction)
    }

    @Test
    fun `invoke returns success result when repository call is successfully`() = runBlockingTest {
        val cityName = "Istanbul"
        val expectedResult = mockWeatherData

        `when`(weatherTransaction.getWeatherLocalDataByName(cityName)).thenReturn(flow {
            emit(
                expectedResult
            )
        })

        val result: Flow<WeatherData> = getWeatherMockDataUseCase(cityName)

        result.collect { actualResult ->
            assertEquals(expectedResult, actualResult)
        }
    }

    @Test
    fun `invoke returns an error when repository fetch fails`() = runTest {
        `when`(weatherTransaction.getWeatherLocalDataByName("Kotlin")).thenAnswer {
            callbackFlow<User> {
                throw RuntimeException("Data fetch error")
            }
        }

        val flow = getWeatherMockDataUseCase("Kotlin")

        flow.catch { e ->
            assertTrue(e is RuntimeException)
        }.collect()
    }
}
