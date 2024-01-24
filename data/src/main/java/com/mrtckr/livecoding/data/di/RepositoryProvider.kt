package com.mrtckr.livecoding.data.di

import com.mrtckr.livecoding.data.WeatherDataSourceImpl
import com.mrtckr.livecoding.data.datasource.IWeatherData
import com.mrtckr.livecoding.data.datasource.WeatherDataSource
import com.mrtckr.livecoding.domain.repository.WeatherTransaction
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryProvider {

    @Binds
    abstract fun bindWeatherRepository(weatherDataSourceImpl: WeatherDataSourceImpl): WeatherTransaction

    @Binds
    abstract fun bindIWeatherData(weatherDataSource: WeatherDataSource): IWeatherData
}
