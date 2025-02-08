package com.aj.bindablerecyclerview.homedata

import com.aj.bindablerecyclerview.homedata.datasource.WeatherForecastDatasource
import com.aj.weathercompose.data.datasource.WeatherForecastDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DiModule {
    @Binds
    abstract fun bindsWeatherDatasource(weatherForecastDatasourceImpl: WeatherForecastDatasourceImpl): WeatherForecastDatasource
}