package com.example.weatheru.data.entity

import com.squareup.moshi.Json

data class Location(
    @Json(name = "country")
    val country: String,
    @Json(name = "lat")
    val lat: String,
    @Json(name = "localtime")
    val localtime: String,
    @field:Json(name = "localtime_epoch")
    val localtimeEpoch: Int,
    @Json(name = "lon")
    val lon: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "region")
    val region: String,
    @field:Json(name = "timezone_id")
    val timezoneId: String,
    @field:Json(name = "utc_offset")
    val utcOffset: String
)