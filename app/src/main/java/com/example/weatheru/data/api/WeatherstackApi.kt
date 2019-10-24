package com.example.weatheru.data.api

import com.example.weatheru.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred

import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherstackApi{

    @GET(value = "current")
    fun getCurrentWeatherAsync(@Query(value = "query") location: String): Deferred<CurrentWeatherResponse>

}


