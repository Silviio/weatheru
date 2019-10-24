package com.example.weatheru.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.weatheru.internal.exception.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptorImpl (context: Context) : ConnectivityInterceptor {

    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {

        if (!hasInternetConnection())
            throw NoConnectivityException()

        return chain.proceed(chain.request())

    }

    private fun hasInternetConnection():Boolean {

        val connectivityManager= appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork

        return if (network != null) {

            val networkCapabilities  = connectivityManager.getNetworkCapabilities(network)

            (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))

        } else {
            false
        }

    }

}