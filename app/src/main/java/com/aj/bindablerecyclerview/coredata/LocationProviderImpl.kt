package com.aj.bindablerecyclerview.coredata

import android.location.Location
import com.aj.bindablerecyclerview.coredomain.LocationProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationProviderImpl @Inject constructor(fusedLocationProviderClient: FusedLocationProviderClient,locationRequest: LocationRequest) : LocationProvider {
    override fun getLastKnownLocation(location: (location: Location) -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun getLocationUpdates(): Flow<Location> {
        TODO("Not yet implemented")
    }

    override fun cancelLocationUpdates() {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentLocation(): Task<Location> {
        TODO("Not yet implemented")
    }
}