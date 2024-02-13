package com.mrtckr.livecoding.data.datasource

import com.mrtckr.livecoding.data.model.FeltTemperatureEntity
import com.mrtckr.livecoding.data.model.ForecastEntity
import com.mrtckr.livecoding.data.model.ForecastHoursEntity
import com.mrtckr.livecoding.data.model.RainfallForecastEntity
import com.mrtckr.livecoding.data.model.UVIndexEntity
import com.mrtckr.livecoding.data.model.ViewingDistanceEntity
import com.mrtckr.livecoding.data.model.WeatherEntity
import com.mrtckr.livecoding.data.retrofit.WeatherService
import com.mrtckr.livecoding.domain.entity.ResultData
import com.mrtckr.livecoding.domain.entity.WeatherStatus
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
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
class WeatherDataDataSourceTest {

    @Mock
    private lateinit var weatherApi: WeatherService

    private lateinit var weatherDataSource: WeatherDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        weatherDataSource = WeatherDataSource(weatherApi, mock(), mock(), mock())
    }

    @Test
    fun `getWeatherByName emits Success when api call is successful`() = runBlockingTest {
        val cityName = "Istanbul"
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
    fun `getWeatherByName emits failed when api call is failed`() = runBlockingTest {
        val fakeResponse = Response.error<WeatherEntity>(
            404, ResponseBody.create(MediaType.get("multipart/mixed"), "error")
        )

        `when`(weatherApi.getWeatherByName("Istanbul")).thenReturn(fakeResponse)
        val result = weatherDataSource.getWeatherByName("Istanbul").first()

        assertTrue(result is ResultData.Error)
    }

    companion object {
        val mockForecastData = arrayListOf(
            ForecastEntity(
                day = "Today",
                temperatureMax = 12,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.CLOUDY
            ), ForecastEntity(
                day = "Friday",
                temperatureMax = 5,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.SNOWY
            ), ForecastEntity(
                day = "Saturday",
                temperatureMax = 5,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.RAINY
            ), ForecastEntity(
                day = "Sunday",
                temperatureMax = 6,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.CLOUDY
            ), ForecastEntity(
                day = "Monday",
                temperatureMax = 6,
                temperatureMin = 0,
                weatherStatus = WeatherStatus.CLOUDY
            ), ForecastEntity(
                day = "Tuesday",
                temperatureMax = 4,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.SNOWY
            ), ForecastEntity(
                day = "Wednesday",
                temperatureMax = 7,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.RAINY
            ), ForecastEntity(
                day = "Thursday",
                temperatureMax = 10,
                temperatureMin = 3,
                weatherStatus = WeatherStatus.CLOUDY
            ), ForecastEntity(
                day = "Friday",
                temperatureMax = 14,
                temperatureMin = 7,
                weatherStatus = WeatherStatus.SUNNY
            ), ForecastEntity(
                day = "Saturday",
                temperatureMax = 15,
                temperatureMin = 8,
                weatherStatus = WeatherStatus.SUNNY
            ), ForecastEntity(
                day = "Sunday",
                temperatureMax = 10,
                temperatureMin = 1,
                weatherStatus = WeatherStatus.CLOUDY
            ), ForecastEntity(
                day = "Monday",
                temperatureMax = 6,
                temperatureMin = -1,
                weatherStatus = WeatherStatus.RAINY
            ), ForecastEntity(
                day = "Tuesday",
                temperatureMax = 3,
                temperatureMin = -4,
                weatherStatus = WeatherStatus.SNOWY
            ), ForecastEntity(
                day = "Wednesday",
                temperatureMax = -3,
                temperatureMin = -10,
                weatherStatus = WeatherStatus.SNOWY
            ), ForecastEntity(
                day = "Thursday",
                temperatureMax = -2,
                temperatureMin = -9,
                weatherStatus = WeatherStatus.SNOWY
            )
        )

        private val mockForecastHours = arrayListOf(
            ForecastHoursEntity(
                hour = "14", temperature = 8, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "15", temperature = 8, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "16", temperature = 7, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "17", temperature = 7, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "18", temperature = 6, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "19", temperature = 5, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "20", temperature = 4, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHoursEntity(
                hour = "21", temperature = 4, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHoursEntity(
                hour = "22", temperature = 3, weatherStatus = WeatherStatus.RAINY,
            ), ForecastHoursEntity(
                hour = "23", temperature = 2, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "00", temperature = 2, weatherStatus = WeatherStatus.CLOUDY,
            ), ForecastHoursEntity(
                hour = "01", temperature = 0, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHoursEntity(
                hour = "02", temperature = -1, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHoursEntity(
                hour = "03", temperature = -1, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHoursEntity(
                hour = "04", temperature = -2, weatherStatus = WeatherStatus.SNOWY,
            ), ForecastHoursEntity(
                hour = "05", temperature = -3, weatherStatus = WeatherStatus.SNOWY,
            )
        )

        val mockWeatherData = WeatherEntity(
            "Cloudy",
            forecast = mockForecastData,
            temperature = 8,
            temperatureMax = 12,
            temperatureMin = 0,
            uvIndex = UVIndexEntity(
                indexPoint = 0, status = "Low\nFor rest of the day"
            ),
            rainfallForecast = RainfallForecastEntity(
                index = "0 mm",
                description = "In the last 24 hours\nNo rain is expected in the next 10 days."
            ),
            feltTemperature = FeltTemperatureEntity(
                degree = 2, description = "The wind feels colder"
            ),
            forecastHours = mockForecastHours,
            viewingDistance = ViewingDistanceEntity(
                visibleDistance = "25 km", description = "It's clear now"
            )
        )
    }
}
