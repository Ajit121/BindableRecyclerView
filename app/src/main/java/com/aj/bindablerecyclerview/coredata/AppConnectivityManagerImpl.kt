package com.aj.bindablerecyclerview.coredata

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.aj.bindablerecyclerview.coredomain.AppConnectivityManager
import com.aj.bindablerecyclerview.network.ApiException
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

@SuppressLint("MissingPermission")
class AppConnectivityManagerImpl @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val networkRequest: NetworkRequest
): AppConnectivityManager, Interceptor {
    override suspend fun hasInternet(): Flow<Boolean> = callbackFlow {
        if(connectivityManager.activeNetwork==null) {
            trySend(false)
        }
        try{
            connectivityManager.requestNetwork(networkRequest,object:NetworkCallback(){
                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities
                ) {
                    super.onCapabilitiesChanged(network, networkCapabilities)
                    val isAvailable = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                    trySend(true)
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    trySend(false)
                }
            })
        }catch (ex: Exception){
            ex.printStackTrace()
        }

        awaitClose{
            channel.close()
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        connectivityManager.activeNetwork?.also{
            connectivityManager.getNetworkCapabilities(it)?.let{
                if(it.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) || it.hasCapability(
                        NetworkCapabilities.NET_CAPABILITY_VALIDATED)){
                    val builder: Request.Builder = chain.request().newBuilder()
                    return chain.proceed(builder.build())
                }else{
                    throw ApiException.NoConnectivityException()
                }
            }
        }?:throw ApiException.NoConnectivityException()
        throw ApiException.NoConnectivityException()
    }
}