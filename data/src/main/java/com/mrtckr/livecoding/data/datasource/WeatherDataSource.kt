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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherDataSource @Inject constructor(private val weatherApi: WeatherService) : IWeatherData {

    private val mockForecastData = arrayListOf(
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

    private val mockWeatherData = WeatherEntity(
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

    override suspend fun getWeatherByName(cityName: String): Flow<ResultData<WeatherEntity>> =
        flow {
            //emit(ResultData.Success(mockWeatherData)) // disable it for real experience
            val response = weatherApi.getWeatherByName(cityName)
            if (response.isSuccessful) {
                val weatherEntity = response.body()
                weatherEntity?.let {
                    //emit(ResultData.Success(it)) // enable it for real experience
                    emit(ResultData.Success(mockWeatherData))  // For mocking - disable it for real experience
                }
            } else {
                if (response.code() != 503) {
                    emit(ResultData.Error(Exception("Error getting weather data: ${response.code()}")))
                } else {
                    emit(ResultData.Success(mockWeatherData))  // For mocking - disable it for real experience
                }
            }
        }.catch { exception ->
            emit(ResultData.Success(mockWeatherData)) // For mocking - enable it for real experience
            /*when (exception) {
                is IOException -> emit(ResultData.Error(Exception("Network error")))
                is HttpException -> emit(ResultData.Error(Exception("HTTP error: ${exception.code()}")))
                else -> emit(ResultData.Error(Exception("Unknown error")))
            }
             */
        }


}
