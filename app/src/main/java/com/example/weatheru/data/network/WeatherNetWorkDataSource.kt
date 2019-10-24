package com.example.weatheru.data.network

import androidx.lifecycle.LiveData
import com.example.weatheru.data.entity.CurrentWeather

interface WeatherNetWorkDataSource {

    val downloadedCurrentWeather : LiveData<CurrentWeather>

    suspend fun fetchCurrentWeather(location: String)

}