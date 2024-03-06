package com.mrtckr.livecoding.data.datasource

import com.mrtckr.livecoding.data.api.WeatherApiService
import com.mrtckr.livecoding.data.datasource.weather.WeatherDataSource
import com.mrtckr.livecoding.data.model.weather.WeatherEntity
import com.mrtckr.livecoding.data.testing.mockWeatherData
import com.mrtckr.livecoding.domain.entity.ResultData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
class WeatherDataDataSourceTest {

    @Mock
    private lateinit var weatherApi: WeatherApiService

    private lateinit var weatherDataSource: WeatherDataSource

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        weatherDataSource = WeatherDataSource(
            weatherApi = weatherApi,
            networkJson = Json { ignoreUnknownKeys = true },
            assets = mock(),
            testDispatcher
        )
    }

    @Test
    fun `getWeatherByName emits Success when api call is successful`() = runTest {
        val cityName = com.mrtckr.livecoding.domain.testing.mockWeatherData.cityName
        val fakeResponse = Response.success(
            mockWeatherData
        )
        `when`(weatherApi.getWeatherByName(cityName)).thenReturn(fakeResponse)

        val result = weatherDataSource.getWeatherByName(cityName)

        assertTrue(result.first() is ResultData.Success)
        assertEquals(
            mockWeatherData, (result.first() as ResultData.Success).data
        )
    }

    @Test
    fun `getWeatherByName emits failed when api call is failed`() = runTest {
        val fakeResponse = Response.error<WeatherEntity>(
            404, ResponseBody.create(MediaType.get("multipart/mixed"), "error")
        )

        `when`(weatherApi.getWeatherByName(com.mrtckr.livecoding.domain.testing.mockWeatherData.cityName)).thenReturn(
            fakeResponse
        )
        val result =
            weatherDataSource.getWeatherByName(com.mrtckr.livecoding.domain.testing.mockWeatherData.cityName)
                .first()

        assertTrue(result is ResultData.Error)
    }
}
