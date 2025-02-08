package com.aj.bindablerecyclerview.homedomain.mapper

import com.aj.bindablerecyclerview.coreui.orEmpty
import com.aj.bindablerecyclerview.homedata.model.DayModel
import com.aj.bindablerecyclerview.homedomain.entity.AirQualityEntity
import com.aj.bindablerecyclerview.homedomain.entity.ConditionEntity
import com.aj.bindablerecyclerview.homedomain.entity.DayEntity

fun DayModel.toDomain(): DayEntity = DayEntity(
    uv = this.uv.orEmpty(),
    airQuality = this.airQuality?.toDomain() ?: AirQualityEntity(),
    condition = this.condition?.toDomain() ?: ConditionEntity(),
    avghumidity = this.avghumidity.orEmpty(),
    avgtempC = this.avgtempC.orEmpty(),
    avgtempF = this.avgtempF.orEmpty(),
    avgvisKm = this.avgvisKm.orEmpty(),
    maxtempF = this.maxtempF.orEmpty(),
    maxtempC = this.maxtempC.orEmpty(),
    mintempC = this.mintempC.orEmpty(),
    mintempF = this.mintempF.orEmpty(),
    dailyChanceOfRain = this.dailyChanceOfRain.orEmpty(),
    dailyChanceOfSnow = this.dailyChanceOfSnow.orEmpty(),
    totalprecipIn = this.totalprecipIn.orEmpty(),
    totalprecipMm = this.totalprecipMm.orEmpty(),
    maxwindKph = this.maxwindKph.orEmpty(),
    maxwindMph = this.maxwindMph.orEmpty(),
    avgvisMiles = this.avgvisMiles.orEmpty(),
    totalsnowmCm = this.totalsnowCm.orEmpty(),
    dailyWillItRain = this.dailyWillItRain.orEmpty(),
    dailyWillItSnow = this.dailyWillItSnow.orEmpty(),
)