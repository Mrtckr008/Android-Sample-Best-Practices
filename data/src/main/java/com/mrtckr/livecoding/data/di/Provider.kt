package com.mrtckr.livecoding.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mrtckr.livecoding.data.WeatherDataSourceImpl
import com.mrtckr.livecoding.data.datasource.IWeatherData
import com.mrtckr.livecoding.data.datasource.WeatherDataSource
import com.mrtckr.livecoding.data.retrofit.WeatherService
import com.mrtckr.livecoding.domain.repository.WeatherTransaction
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object Provider {

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://goweather.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder().create()

}
