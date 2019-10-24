package com.example.weatheru.data.entity


import com.squareup.moshi.Json

data class CurrentWeather(
    @Json(name = "cloudcover")
    val cloudcover: Int,
    @Json(name = "feelslike")
    val feelslike: Int,
    @Json(name = "humidity")
    val humidity: Int,
    @Json(name = "is_day")
    val isDay: String,
    @field:Json(name = "observation_time")
    val observationTime: String,
    @Json(name = "precip")
    val precip: String,
    @Json(name = "pressure")
    val pressure: Int,
    @Json(name = "temperature")
    val temperature: Int,
    @field:Json(name = "uv_index")
    val uvIndex: Int,
    @Json(name = "visibility")
    val visibility: Int,
    @field:Json(name = "weather_code")
    val weatherCode: Int,
    @field:Json(name = "weather_descriptions")
    val weatherDescriptions: List<String>,
    @field:Json(name = "weather_icons")
    val weatherIcons: List<String>,
    @field:Json(name = "wind_degree")
    val windDegree: Int,
    @field:Json(name = "wind_dir")
    val windDir: String,
    @field:Json(name = "wind_speed")
    val windSpeed: Int
)