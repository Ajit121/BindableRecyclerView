package com.aj.bindablerecyclerview.homeui

import com.aj.bindablerecyclerview.coreui.BaseViewModel
import com.aj.bindablerecyclerview.coreui.recyclerviewbinding.RecyclerViewItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val CURRENT_WEATHER_VIEW_TYPE = 0
private const val WEATHER_CONDITION_VIEW_TYPE = 1
@HiltViewModel
class HomeViewModel @Inject constructor(): BaseViewModel<HomeViewModel.Event,HomeViewModel.State>() {

    val viewItems = listOf<RecyclerViewItem>(
        CurrentWeatherRVItem().apply { this.viewType = CURRENT_WEATHER_VIEW_TYPE},
        WeatherConditionRVItem().apply { this.viewType = WEATHER_CONDITION_VIEW_TYPE }
    )
    override fun handleEvent(event: Event) {}

    sealed class Event{}
    sealed class State{}
}