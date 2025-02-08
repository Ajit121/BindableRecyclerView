package com.aj.bindablerecyclerview.homedata.repository

import com.aj.bindablerecyclerview.coreui.Result
import com.aj.bindablerecyclerview.network.ApiException
import com.aj.bindablerecyclerview.homedata.datasource.WeatherForecastDatasource
import com.aj.bindablerecyclerview.homedomain.entity.WeatherForecastEntity
import com.aj.bindablerecyclerview.homedomain.mapper.toDomain
import com.aj.bindablerecyclerview.homedomain.repository.WeatherForecastRepository
import javax.inject.Inject

class WeatherForecastRepositoryImpl @Inject constructor(private val weatherForecastDatasource: WeatherForecastDatasource) :
    WeatherForecastRepository {
    override suspend fun getWeatherForecast(
        lat: Double,
        lng: Double
    ): Result<WeatherForecastEntity> {
        return try {
            val response = weatherForecastDatasource.getLocationWeatherForecast("$lat,$lng")
            Result.success(data = response.toDomain())
        } catch (ex: ApiException) {
            ex.printStackTrace()
            Result.failure(message = ex.message ?: ApiException.ServerError().message)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Result.failure(message = ApiException.ServerError().message)
        }
    }
}