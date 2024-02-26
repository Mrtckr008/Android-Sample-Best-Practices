package com.mrtckr.livecoding.data.api

import com.mrtckr.livecoding.data.model.weather.ForecastEntity
import com.mrtckr.livecoding.data.model.weather.WeatherEntity
import com.mrtckr.livecoding.domain.entity.weather.WeatherData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApiService {

    @GET("weather/{cityName}")
    suspend fun getWeatherByName(@Path("cityName") cityName: String): Response<WeatherEntity>

    @POST("weather")
    suspend fun createUser(@Body user: ForecastEntity): Response<WeatherEntity>

    @PUT("weather/{user_id}")
    suspend fun updateUser(
        @Path("user_id") userId: String, @Body user: ForecastEntity
    ): Response<WeatherEntity>

    @PATCH("weather/{user_id}")
    suspend fun patchUser(
        @Path("user_id") userId: String, @Body user: ForecastEntity
    ): Response<WeatherEntity>

    @DELETE("weather/{user_id}")
    suspend fun deleteUser(@Path("user_id") userId: String): Response<Void>

    @GET("weather")
    suspend fun getWeather(@Query("page") page: Int): Response<List<WeatherData>>

    @GET("weather")
    suspend fun getWeatherWithHeader(@Header("Authorization") authHeader: String): Response<List<WeatherData>>

    @Headers("Authorization: Bearer your_token_here")
    @GET("weather")
    suspend fun getWeatherWithStaticHeader(): Response<List<WeatherData>>

}
