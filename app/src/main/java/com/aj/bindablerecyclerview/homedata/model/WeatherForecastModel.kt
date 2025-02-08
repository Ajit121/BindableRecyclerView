package com.aj.bindablerecyclerview.homedata.model

import com.google.gson.annotations.SerializedName

data class WeatherForecastModel(
    @SerializedName("location") var location: LocationModel? = LocationModel(),
    @SerializedName("current") var current: CurrentWeatherModel? = CurrentWeatherModel(),
    @SerializedName("forecast") var forecast: ForecastModel? = ForecastModel(),
    @SerializedName("alerts")
    var alerts: AlertsModel? = AlertsModel()
)

data class LocationModel(
    @SerializedName("name") var name: String? = null,
    @SerializedName("region") var region: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("lat") var lat: Double? = null,
    @SerializedName("lon") var lon: Double? = null,
    @SerializedName("tz_id") var tzId: String? = null,
    @SerializedName("localtime_epoch") var localtimeEpoch: Int? = null,
    @SerializedName("Localtime") var localtime: String? = null
)

data class ConditionModel(
    @SerializedName("text") var text: String? = null,
    @SerializedName("icon") var icon: String? = null,
    @SerializedName("code") var code: Int? = null
)

data class AirQualityModel(
    @SerializedName("co") var co: Double? = null,
    @SerializedName("no2") var no2: Double? = null,
    @SerializedName("03") var o3: Int? = null,
    @SerializedName("so2") var s02: Double? = null,
    @SerializedName("pm2_5") var pm25: Double? = null,
    @SerializedName("pm10") var pm10: Double? = null,
    @SerializedName("us-epa-index") var usEpaIndex: Int? = null,
    @SerializedName("gb-defra-index") var gbDefraIndex: Int? = null
)

data class CurrentWeatherModel(
    @SerializedName("last_updated_epoch") var lastUpdatedEpoch: Int? = null,
    @SerializedName("last_updated") var LastUpdated: String? = null,
    @SerializedName("temp_c") var tempC: Double? = null,
    @SerializedName("temp_f") var tempF: Double? = null,
    @SerializedName("is_day") var isDay: Int? = null,
    @SerializedName("condition") var condition: ConditionModel? = ConditionModel(),
    @SerializedName("wind_mph") var windMph: Double? = null,
    @SerializedName("wind_kph") var windKph: Double? = null,
    @SerializedName("wind_degree") var windDegree: Int? = null,
    @SerializedName("wind_dir") var windDir: String? = null,
    @SerializedName("pressure_mb") var pressureMb: Int? = null,
    @SerializedName("pressure_in") var pressureIn: Double? = null,
    @SerializedName("precip_mm") var precipMm: Double? = null,
    @SerializedName("precip_in") var precipIn: Double? = null,
    @SerializedName("humidity") var humidity: Int? = null,
    @SerializedName("cloud") var cloud: Int? = null,
    @SerializedName("feelslike_c") var feelslikeC: Double? = null,
    @SerializedName("feelslike_f") var feelslikeF: Double? = null,
    @SerializedName("windchill_c") var windchillC: Double? = null,
    @SerializedName("windchill_f") var windchillF: Double? = null,
    @SerializedName("heatindex_c") var heatindexC: Double? = null,
    @SerializedName("heatindex_f") var heatindexF: Double? = null,
    @SerializedName("dewpoint_c") var dewpointC: Double? = null,
    @SerializedName("dewpoint_f") var dewpointF: Double? = null,
    @SerializedName("vis_km") var visKm: Double? = null,
    @SerializedName("vis_miles") var visMiles: Int? = null,
    @SerializedName("uv") var uv: Double? = null,
    @SerializedName("gust_mph") var gustMph: Double? = null,
    @SerializedName("gust_kph") var gustKph: Double? = null,
    @SerializedName("air_quality") var airQuality: AirQualityModel? = AirQualityModel()
)

data class DayModel(
    @SerializedName("maxtemp_c") var maxtempC: Double? = null,
    @SerializedName("maxtemp_f") var maxtempF: Double? = null,
    @SerializedName("mintemp_c") var mintempC: Double? = null,
    @SerializedName("mintemp_f") var mintempF: Double? = null,
    @SerializedName("avgtemp_c") var avgtempC: Double? = null,
    @SerializedName("avgtemp_f") var avgtempF: Double? = null,
    @SerializedName("maxwind_mph") var maxwindMph: Double? = null,
    @SerializedName("maxwind_kph") var maxwindKph: Double? = null,
    @SerializedName("totalprecip_mm") var totalprecipMm: Double? = null,
    @SerializedName("totalprecip_in") var totalprecipIn: Double? = null,
    @SerializedName("totalsnow_cm") var totalsnowCm: Int? = null,
    @SerializedName("avgvis_km") var avgvisKm: Double? = null,
    @SerializedName("avgvis_miles") var avgvisMiles: Int? = null,
    @SerializedName("avghumidity") var avghumidity: Int? = null,
    @SerializedName("daily_will_it_rain") var dailyWillItRain: Int? = null,
    @SerializedName("daily_chance_of_rain") var dailyChanceOfRain: Int? = null,
    @SerializedName("daily_will_it_snow") var dailyWillItSnow: Int? = null,
    @SerializedName("daily_chance_of_snow") var dailyChanceOfSnow: Int? = null,
    @SerializedName("condition") var condition: ConditionModel? = ConditionModel(),
    @SerializedName("uv") var uv: Double? = null,
    @SerializedName("air_quality") var airQuality: AirQualityModel? = AirQualityModel()
)

data class AstroModel(
    @SerializedName("sunrise") var sunrise: String? = null,
    @SerializedName("sunset") var sunset: String? = null,
    @SerializedName("moonrise") var moonrise: String? = null,
    @SerializedName("moonset") var moonset: String? = null,
    @SerializedName("moon_phase") var moonPhase: String? = null,
    @SerializedName("moon_illumination") var moonIllumination: Int? = null,
    @SerializedName("is_moon_up") var isMoonUp: Int? = null,
    @SerializedName("is_sun_up") var isSunUp: Int? = null
)

data class HourModel(
    @SerializedName("time_epoch") var timeEpoch: Int? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("temp_c") var tempC: Double? = null,
    @SerializedName("temp_f") var tempF: Double? = null,
    @SerializedName("is_day") var isDay: Int? = null,
    @SerializedName("condition") var condition: ConditionModel? = ConditionModel(),
    @SerializedName("wind_mph") var windMph: Double? = null,
    @SerializedName("wind_kph") var windKph: Double? = null,
    @SerializedName("wind_degree") var windDegree: Int? = null,
    @SerializedName("wind_dir") var windDir: String? = null,
    @SerializedName("pressure_mb") var pressureMb: Int? = null,
    @SerializedName("pressure_in") var pressureIn: Double? = null,
    @SerializedName("precip_mm") var precipMm: Double? = null,
    @SerializedName("precip_in") var precipIn: Double? = null,
    @SerializedName("snow_cm") var snowCm: Int? = null,
    @SerializedName("humidity") var humidity: Int? = null,
    @SerializedName("cloud") var cloud: Int? = null,
    @SerializedName("feelslike_c") var feelslikeC: Double? = null,
    @SerializedName("feelslike_f") var feelslikeF: Double? = null,
    @SerializedName("windchill_c") var windchillC: Double? = null,
    @SerializedName("windchill_f") var windchillF: Double? = null,
    @SerializedName("heatindex_c") var heatindexC: Double? = null,
    @SerializedName("heatindex_f") var heatindexF: Double? = null,
    @SerializedName("dewpoint_c") var dewpointC: Double? = null,
    @SerializedName("dewpoint_f") var dewpointF: Double? = null,
    @SerializedName("will_it_rain") var willItRain: Int? = null,
    @SerializedName("chance_of_rain") var chancefRain: Int? = null,
    @SerializedName("will_it_snow") var willItSnow: Int? = null,
    @SerializedName("chance_of_snow") var chanceOfSnow: Int? = null,
    @SerializedName("vis_km") var visKm: Double? = null,
    @SerializedName("vis_miles") var visMiles: Int? = null,
    @SerializedName("gust_mph") var gustMph: Double? = null,
    @SerializedName("gust_kph") var gustKph: Double? = null,
    @SerializedName("uv") var uv: Double? = null,
    @SerializedName("air_quality") var airQuality: AirQualityModel? = AirQualityModel()
)

data class ForecastDayModel(
    @SerializedName("date") var date: String? = null,
    @SerializedName("date_epoch") var dateEpoch: Int? = null,
    @SerializedName("day") var day: DayModel? = DayModel(),
    @SerializedName("astro") var astro: AstroModel? = AstroModel(),
    @SerializedName("hour") var hour: ArrayList<HourModel> = arrayListOf()
)

data class ForecastModel(
    @SerializedName("forecastday") var forecastday: ArrayList<ForecastDayModel> = arrayListOf()
)

data class AlertsModel(
    @SerializedName("alert") var alert: ArrayList<String> = arrayListOf()
)