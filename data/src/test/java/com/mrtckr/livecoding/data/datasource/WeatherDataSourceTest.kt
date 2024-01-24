package com.mrtckr.livecoding.data.datasource

import com.mrtckr.livecoding.data.model.WeatherEntity
import com.mrtckr.livecoding.data.retrofit.WeatherService
import com.mrtckr.livecoding.domain.entity.ResultData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
class WeatherDataSourceTest {

    @Mock
    private lateinit var weatherApi: WeatherService

    private lateinit var weatherDataSource: WeatherDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        weatherDataSource = WeatherDataSource(weatherApi)
    }

    @Test
    fun `getWeatherByName emits Success when api call is successful`() = runBlockingTest {
        val cityName = "TestCity"
        val fakeResponse = Response.success(
            WeatherEntity(
                description = "cold weather",
                forecast = arrayListOf(),
                temperature = "+2 C",
                wind = "15f"
            )
        )
        `when`(weatherApi.getWeatherByName(cityName)).thenReturn(fakeResponse)

        val result = weatherDataSource.getWeatherByName(cityName)

        assertTrue(result.first() is ResultData.Success)
        assertEquals(
            WeatherEntity(
                description = "cold weather",
                forecast = arrayListOf(),
                temperature = "+2 C",
                wind = "15f"
            ), (result.first() as ResultData.Success).data
        )
    }

    @Test
    fun `getWeatherByName emits failed when api call is failed`() = runBlockingTest {
        val fakeResponse = Response.error<WeatherEntity>(404, ResponseBody.create(MediaType.get("multipart/mixed"),"error"))

        `when`(weatherApi.getWeatherByName("Berlin")).thenReturn(fakeResponse)
        val result = weatherDataSource.getWeatherByName("Berlin").first()

        assertTrue(result is ResultData.Error)
    }

}
