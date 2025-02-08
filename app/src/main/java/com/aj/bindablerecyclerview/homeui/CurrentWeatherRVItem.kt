package com.aj.bindablerecyclerview.homeui

import com.aj.bindablerecyclerview.R
import com.aj.bindablerecyclerview.coreui.recyclerviewbinding.RecyclerViewItem

class CurrentWeatherRVItem: RecyclerViewItem {
    override val layoutId: Int = R.layout.rv_current_weather

    override var viewType: Int = 0
    override val data: Any = ""

    override fun areContentTheSame(other: RecyclerViewItem): Boolean {
        return other is CurrentWeatherRVItem
    }

    override fun areItemsTheSame(other: RecyclerViewItem): Boolean {
        return other is CurrentWeatherRVItem
    }
}