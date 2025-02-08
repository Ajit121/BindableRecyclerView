package com.aj.bindablerecyclerview.homedata.datasource

import com.aj.bindablerecyclerview.homedata.model.WeatherForecastModel

interface WeatherForecastDatasource {
    suspend fun getLocationWeatherForecast(latLng: String): WeatherForecastModel
}