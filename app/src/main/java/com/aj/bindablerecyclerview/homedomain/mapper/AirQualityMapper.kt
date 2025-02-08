package com.aj.bindablerecyclerview.homedomain.mapper

import com.aj.bindablerecyclerview.coreui.orEmpty
import com.aj.bindablerecyclerview.homedata.model.AirQualityModel
import com.aj.bindablerecyclerview.homedomain.entity.AirQualityEntity

fun AirQualityModel.toDomain(): AirQualityEntity {
    return AirQualityEntity(
        this.co.orEmpty(),
        o3 = this.o3.orEmpty(),
        pm10 = this.pm10.orEmpty(),
        pm25 = this.pm25.orEmpty(),
        no2 = this.no2.orEmpty(),
        s02 = this.s02.orEmpty(),
        gbDefraIndex = this.gbDefraIndex.orEmpty(),
        usEpaIndex = this.usEpaIndex.orEmpty()
    )
}