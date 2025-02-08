package com.aj.bindablerecyclerview.di

import android.content.Context
import android.location.Geocoder
import com.google.android.gms.location.LocationRequest
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.aj.bindablerecyclerview.appdata.ResourceProviderImpl
import com.aj.bindablerecyclerview.appdomain.ResourceProvider
import com.aj.bindablerecyclerview.coredata.AppConnectivityManagerImpl
import com.aj.bindablerecyclerview.coredata.LocationProviderImpl
import com.aj.bindablerecyclerview.coredomain.AppConnectivityManager
import com.aj.bindablerecyclerview.coredomain.LocationProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.Locale
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindsAppConnectivityManager(appConnectivityManagerImpl: AppConnectivityManagerImpl): AppConnectivityManager

    @Binds
    abstract fun resourceProvider(resourceProviderImpl: ResourceProviderImpl): ResourceProvider

    companion object {
        @Provides
        fun providesNetworkRequest(): NetworkRequest =
            NetworkRequest.Builder().addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR).build()

        @Provides
        @Singleton
        fun providesConnectivityManager(
            @ApplicationContext context: Context
        ): ConnectivityManager {
            return context.getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        }

        fun providesLocationRequest(): LocationRequest {
            val locationInterval = 2000L
            val locationFastestInterval = 2000L
            return LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, locationInterval)
                .setWaitForAccurateLocation(false)
                .setMinUpdateIntervalMillis(locationFastestInterval).build()
        }

        @Provides
        fun providesFusedLocationProviderClient(@ApplicationContext context: Context): FusedLocationProviderClient {
            return LocationServices.getFusedLocationProviderClient(context)
        }

        @Provides
        fun providesLocationProvider(
            fusedLocationProviderClient: FusedLocationProviderClient,
            locationRequest: LocationRequest
        ): LocationProvider {
            return LocationProviderImpl(
                fusedLocationProviderClient = fusedLocationProviderClient,
                locationRequest = locationRequest
            )
        }

        @Provides
        fun providesGeoCoder(@ApplicationContext context: Context): Geocoder {
            return Geocoder(context, Locale.getDefault())
        }
    }
}