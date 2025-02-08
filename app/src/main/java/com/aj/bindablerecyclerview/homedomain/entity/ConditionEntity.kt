package com.aj.bindablerecyclerview.homedomain.entity

data class ConditionEntity(
    val text: String,
    val code: String,
    val icon: String
) {
    constructor() : this("--", "", "")
}
