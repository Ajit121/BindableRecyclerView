package com.aj.bindablerecyclerview.homedomain.entity

data class AirQualityEntity(
    val co: String,
    val no2: String,
    val o3: String,
    val s02: String,
    val pm25: String,
    val pm10: String,
    val usEpaIndex: String,
    val gbDefraIndex: String
) {
    constructor() : this("--", "--", "--", "--", "--", "--", "--", "--")
}