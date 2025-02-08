package com.aj.bindablerecyclerview.network

import com.aj.bindablerecyclerview.homedata.model.WeatherForecastModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val WEATHER_API_KEY = "a9d0d2d1641c4032a5e90047240910"
interface WeatherApiService {
    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("q")latLng:String,
        @Query ("days")days:String = "5",
        @Query("key")apiid:String = WEATHER_API_KEY
    ): Response<WeatherForecastModel>
}