package com.aj.bindablerecyclerview.homedomain.mapper

import com.aj.bindablerecyclerview.coreui.orEmpty
import com.aj.bindablerecyclerview.homedata.model.LocationModel
import com.aj.bindablerecyclerview.homedomain.entity.LocationEntity

fun LocationModel.toDomain(): LocationEntity =
    LocationEntity(
        name = this.name.orEmpty(),
        region = this.region.orEmpty(),
        country = this.country.orEmpty(),
        tzId = this.tzId.orEmpty(),
        lat = this.lat.orEmpty(),
        lon = this.lon.orEmpty(),
        localtime = this.localtime.orEmpty(),
        localtimeEpoch = this.localtimeEpoch ?: 0
    )