package com.aj.bindablerecyclerview.homedomain

import com.aj.bindablerecyclerview.homedata.repository.WeatherForecastRepositoryImpl
import com.aj.bindablerecyclerview.homedomain.repository.WeatherForecastRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DiModule {
    @Binds
    abstract fun providesWeatherRepository(weatherForecastRepositoryImpl: WeatherForecastRepositoryImpl): WeatherForecastRepository
}