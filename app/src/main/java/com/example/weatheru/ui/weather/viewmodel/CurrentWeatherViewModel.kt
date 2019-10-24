package com.example.weatheru.ui.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weatheru.data.entity.CurrentWeather

import com.example.weatheru.data.repository.WeatherURepository


class CurrentWeatherViewModel(private val weatherURepository: WeatherURepository) : ViewModel() {

    suspend fun getCurrentWeather(location: String): LiveData<CurrentWeather> = weatherURepository.getCurrentWeather(location)

}
