package com.aj.bindablerecyclerview.homedomain.mapper

import com.aj.bindablerecyclerview.homedata.model.WeatherForecastModel
import com.aj.bindablerecyclerview.homedomain.entity.CurrentWeatherEntity
import com.aj.bindablerecyclerview.homedomain.entity.ForecastEntity
import com.aj.bindablerecyclerview.homedomain.entity.LocationEntity
import com.aj.bindablerecyclerview.homedomain.entity.WeatherForecastEntity

fun WeatherForecastModel.toDomain(): WeatherForecastEntity = WeatherForecastEntity(
    alerts = this.alerts?.alert?.map {
        it
    } ?: emptyList(),
    currentWeather = this.current?.toDomain()
    ?: CurrentWeatherEntity(), location = this. location?.toDomain() ?: LocationEntity(),
forecast = this. forecast?.toDomain() ?: ForecastEntity())