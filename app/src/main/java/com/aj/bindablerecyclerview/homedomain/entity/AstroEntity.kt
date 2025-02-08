package com.aj.bindablerecyclerview.homedomain.entity

data class AstroEntity(
    var sunrise: String,
    var sunset: String,
    var moonrise: String,
    var moonset: String,
    var moonPhase: String,
    var moonIllumination: String,
    var isMoonUp: String,
    var isSunUp: String
) {
    constructor() : this("", "", "", "", "", "", "", "")
}
