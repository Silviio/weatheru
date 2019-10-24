package com.example.weatheru.data.repository

import androidx.lifecycle.LiveData
import com.example.weatheru.data.entity.CurrentWeather

interface WeatherURepository {
    suspend fun getCurrentWeather(location: String):LiveData<CurrentWeather>
}