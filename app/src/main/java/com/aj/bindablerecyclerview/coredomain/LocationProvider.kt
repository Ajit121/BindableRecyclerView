package com.aj.bindablerecyclerview.coredomain

import android.location.Location
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.flow.Flow

interface LocationProvider {
    fun getLastKnownLocation(location: (location: Location) -> Unit)
    suspend fun getLocationUpdates(): Flow<Location>
    fun cancelLocationUpdates ()
    suspend fun getCurrentLocation(): Task<Location>
}