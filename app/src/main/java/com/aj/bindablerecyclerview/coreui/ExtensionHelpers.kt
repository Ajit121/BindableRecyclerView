package com.aj.bindablerecyclerview.coreui

fun Int?.orEmpty(): String = this?.let { this.toString() } ?: ""
fun Double?.orEmpty(): String = this?.let { this.toInt().toString() } ?: ""
