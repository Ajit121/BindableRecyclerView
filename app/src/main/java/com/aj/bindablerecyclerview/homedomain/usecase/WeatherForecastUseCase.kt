package com.aj.bindablerecyclerview.homedomain.usecase

import com.aj.bindablerecyclerview.coreui.Result
import com.aj.bindablerecyclerview.coreui.UseCase
import com.aj.bindablerecyclerview.homedomain.entity.WeatherForecastEntity
import com.aj.bindablerecyclerview.homedomain.repository.WeatherForecastRepository
import javax.inject.Inject

class WeatherForecastUseCase @Inject constructor(private val weatherForecastRepository: WeatherForecastRepository) :
    UseCase<WeatherForecastParams, Result<WeatherForecastEntity>>() {
    override suspend fun invoke(params: WeatherForecastParams): Result<WeatherForecastEntity> =
        weatherForecastRepository.getWeatherForecast(params.lat, params.lng)
}

data class WeatherForecastParams(val lat: Double, val lng: Double)