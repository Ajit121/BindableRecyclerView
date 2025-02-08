package com.aj.bindablerecyclerview.homedomain.mapper

import com.aj.bindablerecyclerview.coreui.orEmpty
import com.aj.bindablerecyclerview.homedata.model.CurrentWeatherModel
import com.aj.bindablerecyclerview.homedomain.entity.AirQualityEntity
import com.aj.bindablerecyclerview.homedomain.entity.ConditionEntity
import com.aj.bindablerecyclerview.homedomain.entity.CurrentWeatherEntity

fun CurrentWeatherModel.toDomain(): CurrentWeatherEntity = CurrentWeatherEntity(
    uv = this.uv.orEmpty(),
    tempF = this.tempF.orEmpty(),
    isDay = if(this.isDay==0)false else true,
    airQuality = this.airQuality?.toDomain()?: AirQualityEntity(),
    condition = this.condition?.toDomain()?: ConditionEntity(),
    cloud = this.cloud.orEmpty(),
    tempC = this.tempC.orEmpty(),
    visKm = this.visKm.orEmpty(),
    humidity = this.humidity.orEmpty(),
    precipIn = this.precipIn.orEmpty(),
    precipMm = this.precipMm.orEmpty(),
    visMiles = this.visMiles.orEmpty(),
    lastUpdatedEpoch = this.lastUpdatedEpoch?:0,
    gustKph = this.gustKph.orEmpty(),
    gustMph = this.gustMph.orEmpty(),
    windDir = this.windDir.orEmpty(),
    windKph = this.windKph.orEmpty(),
    windMph = this.windMph.orEmpty(),
    dewpointC = this.dewpointC.orEmpty(),
    dewpointF = this.dewpointF.orEmpty(),
    feelslikeF = this.feelslikeF.orEmpty(),
    feelslikeC = this.feelslikeC.orEmpty(),
    heatindexF = this.heatindexF.orEmpty(),
    heatindexC = this.heatindexC.orEmpty(),
    pressureIn = this.pressureIn.orEmpty(),
    windchillC = this.windchillC.orEmpty(),
    windchillF = this.windchillF.orEmpty(),
    windDegree = this.windDegree.orEmpty(),
    lastUpdated = this.LastUpdated.orEmpty()
)