package com.aj.bindablerecyclerview.appdomain

import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes

interface ResourceProvider {
    fun getString(@StringRes resId:Int, formatArgs: String? = null): String
    fun getView(@LayoutRes resId: Int): View
}