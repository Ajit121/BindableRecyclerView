package com.aj.bindablerecyclerview.homedomain.repository

import com.aj.bindablerecyclerview.coreui.Result
import com.aj.bindablerecyclerview.homedomain.entity.WeatherForecastEntity

interface WeatherForecastRepository {
    suspend fun getWeatherForecast(lat:Double,lng:Double): Result<WeatherForecastEntity>
}