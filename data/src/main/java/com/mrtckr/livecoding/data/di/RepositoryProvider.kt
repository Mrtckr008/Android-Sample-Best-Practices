package com.mrtckr.livecoding.data.di

import com.mrtckr.livecoding.data.UserDataSourceImpl
import com.mrtckr.livecoding.data.WeatherDataSourceImpl
import com.mrtckr.livecoding.data.datasource.UserDataDataSource
import com.mrtckr.livecoding.data.datasource.UserService
import com.mrtckr.livecoding.data.datasource.WeatherDataSource
import com.mrtckr.livecoding.data.datasource.WeatherService
import com.mrtckr.livecoding.domain.repository.UserRepository
import com.mrtckr.livecoding.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryProvider {

    @Binds
    abstract fun bindWeatherRepository(weatherDataSourceImpl: WeatherDataSourceImpl): WeatherRepository

    @Binds
    abstract fun bindIWeatherData(weatherDataSource: WeatherDataSource): WeatherService

    @Binds
    abstract fun bindUserTransaction(userDataSourceImpl: UserDataSourceImpl): UserRepository

    @Binds
    abstract fun bindIUserData(userDataDataSource: UserDataDataSource): UserService
}
