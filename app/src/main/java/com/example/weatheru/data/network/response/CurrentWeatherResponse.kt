package com.example.weatheru.data.network.response


import com.example.weatheru.data.entity.CurrentWeather
import com.example.weatheru.data.entity.Location
import com.example.weatheru.data.entity.RequestInfo
import com.squareup.moshi.Json

data class CurrentWeatherResponse(
    @Json(name = "current")
    val current: CurrentWeather,
    @Json(name = "location")
    val location: Location,
    @Json(name = "request")
    val request: RequestInfo
)