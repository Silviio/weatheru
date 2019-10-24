package com.example.weatheru.data.entity


import com.squareup.moshi.Json

data class RequestInfo(
    @Json(name = "language")
    val language: String,
    @Json(name = "query")
    val query: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "unit")
    val unit: String
)