package com.aj.weathercompose.data.datasource

import com.aj.bindablerecyclerview.homedata.datasource.WeatherForecastDatasource
import com.aj.bindablerecyclerview.network.ApiException
import com.aj.bindablerecyclerview.network.WeatherApiService
import com.aj.bindablerecyclerview.homedata.model.WeatherForecastModel
import javax.inject.Inject

class WeatherForecastDatasourceImpl @Inject constructor(private val weatherApiService: WeatherApiService) :
    WeatherForecastDatasource {
    override suspend fun getLocationWeatherForecast(latLng: String): WeatherForecastModel {
        try {
            weatherApiService.getWeatherForecast(latLng).body()?.let {
                return it
            } ?: throw ApiException.ServerError()
        } catch (ex: ApiException) {
            ex.printStackTrace()
            throw ex
        } catch (ex: Exception) {
            ex.printStackTrace()
            throw ex
        }
    }
}