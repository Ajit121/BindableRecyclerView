package com.aj.bindablerecyclerview.homeui

import com.aj.bindablerecyclerview.R
import com.aj.bindablerecyclerview.coreui.BaseViewModel
import com.aj.bindablerecyclerview.coreui.recyclerviewbinding.RecyclerViewItem
import javax.inject.Inject

class WeatherConditionRVItem @Inject constructor() : RecyclerViewItem,
    BaseViewModel<WeatherConditionRVItem.Event, WeatherConditionRVItem.State>() {
    override val layoutId: Int = R.layout.rv_weather_condition
    override val data: Any = ""
    override var viewType: Int = 0

    override fun areContentTheSame(other: RecyclerViewItem): Boolean {
        return other is WeatherConditionRVItem
    }

    override fun areItemsTheSame(other: RecyclerViewItem): Boolean {
        return other is WeatherConditionRVItem
    }

    sealed class Event {}
    sealed class State {}
}