package com.aj.bindablerecyclerview.homedomain.entity

data class HourEntity(
    var timeEpoch: String,
    var time: String,
    var tempC: String,
    var tempF: String,
    var isDay: String,
    var condition: ConditionEntity,
    var windMph: String,
    var windKph: String,
    var windDegree: String,
    var windDir: String,
    var pressurelb: String,
    var pressureIn: String,
    var precipMm: String,
    var precipIn: String,
    var snowCm: String,
    var humidity: String,
    var cloud: String,
    var feelslikeC: String,
    var feelslikeF: String,
    var windchillC: String,
    var windchillF: String,
    var heatindexC: String,
    var heatindexF: String,
    var dewpointC: String,
    var dewpointF: String,
    var chanceOfRain: String,
    var chanceOfSnow: String,
    var willItRain: String,
    var willItSnow: String,
    var viskm: String,
    var visMiles: String,
    var gustMph: String,
    var gustKph: String,
    var uv: String,
    var airQuality: AirQualityEntity
) {
    constructor() : this(
        "",
        "", "",
        "",
        "", ConditionEntity(), "", "", "", "",
        "", "", "", "",
        "", "", "", "", "", "", "",
        "", "", "", "", "", "", "",
        "", "", "", "", "", "", AirQualityEntity()
    )
}

data class ForecastDayEntity(
    var date: String,
    var dateEpoch: Int,
    var day: DayEntity,
    var astro: AstroEntity,
    var hour: List<HourEntity>
) {
    constructor() : this(
        "", 0, DayEntity(), AstroEntity(), emptyList()
    )
}


data class ForecastEntity(
    var forecastday: List<ForecastDayEntity>
) {
    constructor() : this(emptyList())
}