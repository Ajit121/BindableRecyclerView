package com.aj.bindablerecyclerview.homedomain.entity

data class WeatherForecastEntity(
    val location: LocationEntity,
    val currentWeather: CurrentWeatherEntity,
    val forecast: ForecastEntity,
    val alerts: List<String>
) {
    constructor() : this(
        LocationEntity(),
        CurrentWeatherEntity(),
        ForecastEntity(),
        emptyList()
    )
}


val dummyWeatherForecastData
    get() = WeatherForecastEntity(
        LocationEntity().apply {
            name = "Kolkata"
            region = "West Bengal"
            country = "India"
            lat = "22.5697"
            lon = "88.3697"
            tzId = "Asia / Kolkata"
            localtimeEpoch = 1728540335
            localtime = "2024 - 10 - 10 11:35"
        },
        CurrentWeatherEntity().apply {
            lastUpdatedEpoch = 1728540000
            lastUpdated = "2024-10-10 11:30"
            tempC = "33"
            tempF = "91"
            isDay = true
            condition = dummyCondition
            windMph = "5"
            windKph = "9"
            windDegree = "224"
            windDir = "SW"
            pressureIn = "29"
            precipMm = "0"
            precipIn = "0"
            humidity = "63"
            cloud = "50"
            feelslikeC = "40"
            feelslikeF = "104"
            windchillC = "32"
            windchillF = "90"
            heatindexC = "38"
            visMiles = "2"
            uv = "7"
            gustMph = "9"
            gustKph = "15"
        },
        ForecastEntity(
            forecastday = listOf(
                ForecastDayEntity(
                    dateEpoch = 0,
                    date = "",
                    hour = emptyList(),
                    astro = AstroEntity().apply {
                        sunrise = "05:42 AM"
                        sunset = "05:21 PM"
                        moonrise = "03:14 PM"
                        moonset = "02:03 AM"
                        moonPhase = "Waxing Gibbous"
                        moonIllumination = "83"
                        isMoonUp = ""
                        isSunUp = "0"
                    },
                    day = DayEntity()
                )
            )
        ),
        alerts = listOf()
    )

val dummyCondition
    get() = ConditionEntity().copy(
        text = "Moderate or heavy rain with thunder",
        icon = "//cdn.weatherapi.com/weather/64x64/day/143.png",
        code = "1030"
    )