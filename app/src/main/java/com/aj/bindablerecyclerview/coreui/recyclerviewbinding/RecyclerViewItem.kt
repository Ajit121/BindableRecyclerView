package com.aj.bindablerecyclerview.coreui.recyclerviewbinding

import androidx.annotation.LayoutRes

interface RecyclerViewItem {
    @get: LayoutRes
    val layoutId: Int
    val viewType: Int
        get() = 0
    val data: Any

    fun areContentTheSame(other: RecyclerViewItem): Boolean

    fun areItemsTheSame(other: RecyclerViewItem): Boolean
}