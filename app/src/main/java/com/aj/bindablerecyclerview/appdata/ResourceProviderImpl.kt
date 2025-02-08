package com.aj.bindablerecyclerview.appdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.aj.bindablerecyclerview.R
import com.aj.bindablerecyclerview.appdomain.ResourceProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
): ResourceProvider {
    override fun getString(resId: Int, formatArgs: String?): String = formatArgs?.let{
        context.getString(resId,it)
    }?:context.getString(resId)

    override fun getView(resId: Int): View = LayoutInflater.from(context).inflate(resId,null)
}