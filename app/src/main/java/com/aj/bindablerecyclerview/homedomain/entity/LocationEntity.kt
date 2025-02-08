package com.aj.bindablerecyclerview.homedomain.entity


data class LocationEntity(
    var name: String,
    var region: String,
    var country: String,
    var lat: String,
    var lon: String,
    var tzId: String,
    var localtimeEpoch: Int,
    var localtime: String
) {
    constructor() : this(
        "", "",
        "", "", "", "", 0, ""
    )
}