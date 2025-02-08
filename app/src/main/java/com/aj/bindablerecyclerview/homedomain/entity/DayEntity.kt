package com.aj.bindablerecyclerview.homedomain.entity

data class DayEntity(
    var maxtempC: String,
    var maxtempF: String,
    var mintempC: String,
    var mintempF: String,
    var avgtempC: String,
    var avgtempF: String,
    var maxwindMph: String,
    var maxwindKph: String,
    var totalprecipMm: String,
    var totalprecipIn: String,
    var totalsnowmCm: String,
    var avgvisKm: String,
    var avgvisMiles: String,
    var avghumidity: String,
    var dailyWillItRain: String,
    var dailyChanceOfRain: String,
    var dailyWillItSnow: String,
    var dailyChanceOfSnow: String,
    var condition: ConditionEntity,
    var uv: String,
    var airQuality: AirQualityEntity
) {
    constructor() : this(
        "", "", "", "", "",
        "", "", "", "", "", "", "",
        "", "", "", "", "", "", ConditionEntity(), "", AirQualityEntity()
    )
}
