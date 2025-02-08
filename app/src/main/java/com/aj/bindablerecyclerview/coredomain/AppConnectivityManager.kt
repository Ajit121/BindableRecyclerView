package com.aj.bindablerecyclerview.coredomain

import kotlinx.coroutines.flow.Flow

interface AppConnectivityManager {
    suspend fun hasInternet(): Flow<Boolean>
}