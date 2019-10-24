package com.example.weatheru.data.network.interceptor


import com.example.weatheru.data.network.config.NetworkConfig.API_KEY
import okhttp3.Interceptor
import okhttp3.Response



class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

            var req = chain.request()

            val url = req.url().newBuilder().addQueryParameter("access_key", API_KEY).build()

            req = req.newBuilder().url(url).build()

            return chain.proceed(req)
    }
}