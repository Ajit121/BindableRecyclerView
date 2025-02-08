package com.aj.bindablerecyclerview.homedomain.mapper

import com.aj.bindablerecyclerview.coreui.orEmpty
import com.aj.bindablerecyclerview.homedata.model.AstroModel
import com.aj.bindablerecyclerview.homedata.model.ForecastDayModel
import com.aj.bindablerecyclerview.homedata.model.ForecastModel
import com.aj.bindablerecyclerview.homedata.model.HourModel
import com.aj.bindablerecyclerview.homedomain.entity.AirQualityEntity
import com.aj.bindablerecyclerview.homedomain.entity.AstroEntity
import com.aj.bindablerecyclerview.homedomain.entity.ConditionEntity
import com.aj.bindablerecyclerview.homedomain.entity.DayEntity
import com.aj.bindablerecyclerview.homedomain.entity.ForecastDayEntity
import com.aj.bindablerecyclerview.homedomain.entity.ForecastEntity
import com.aj.bindablerecyclerview.homedomain.entity.HourEntity

fun ForecastModel.toDomain(): ForecastEntity = ForecastEntity(
    forecastday = this.forecastday.map {
        it.toDomain()
    }
)

fun ForecastDayModel.toDomain(): ForecastDayEntity =
    ForecastDayEntity(
        date = this.date.orEmpty(),
        dateEpoch = 0,
        astro = this.astro?.toDomain() ?: AstroEntity(),
        day = this.day?.toDomain() ?: DayEntity(),
        hour = this.hour.map { it.toDomain() }
    )

private fun HourModel.toDomain(): HourEntity = HourEntity(
     timeEpoch = this.timeEpoch.orEmpty(),
    time = this.time.orEmpty(),
    windchillC = this.windchillC.orEmpty(),
    windDegree = this.windDegree.orEmpty(),
    dewpointF = this.dewpointF.orEmpty(),
    precipMm = this.precipMm.orEmpty(),
    uv = this.uv.orEmpty(),
    visMiles = this.visMiles.orEmpty(),
    tempC = this.tempC.orEmpty(),
    gustMph = this.gustMph.orEmpty(),
    windDir = this.windDir.orEmpty(),
    windKph = this.windKph.orEmpty(),
    windMph = this.windMph.orEmpty(),
    tempF = this.tempF.orEmpty(),
    isDay = this.isDay.orEmpty(),
    humidity = this.humidity.orEmpty(),
    precipIn = this.precipIn.orEmpty(),
    airQuality = this.airQuality?.toDomain()?: AirQualityEntity(),
    condition = this.condition?.toDomain()?: ConditionEntity(),
    cloud = this.cloud.orEmpty(),
    gustKph = this.gustKph.orEmpty(),
    viskm = this.visKm.orEmpty(),
    snowCm = this.snowCm.orEmpty(),
    dewpointC = this.dewpointC.orEmpty(),
    chanceOfRain = this.chancefRain.orEmpty(),
    chanceOfSnow = this.chanceOfSnow.orEmpty(),
    feelslikeC = this.feelslikeC.orEmpty(),
    feelslikeF = this.feelslikeF.orEmpty(),
    heatindexC = this.heatindexC.orEmpty(),
    heatindexF = this.heatindexF.orEmpty(),
    pressureIn = this.pressureIn.orEmpty(),
    pressurelb = this.pressureMb.orEmpty(),
    willItRain = this.willItRain.orEmpty(),
    willItSnow = this.willItSnow.orEmpty(),
    windchillF = this.windchillF.orEmpty()
)

fun AstroModel.toDomain()
        : AstroEntity = AstroEntity(
    sunset = this.sunset.orEmpty(),
    sunrise = this.sunrise.orEmpty(),
    isSunUp = this.isSunUp.orEmpty(),
    isMoonUp = this.isMoonUp.orEmpty(),
    moonPhase = this.moonPhase.orEmpty(),
    moonrise = this.moonrise.orEmpty(),
    moonset = this.moonset.orEmpty(),
    moonIllumination = this.moonIllumination.orEmpty(),
)