package com.example.weatheru.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatheru.data.entity.CurrentWeather
import com.example.weatheru.data.network.WeatherNetWorkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherURepositoryImpl(

    private val weatherNetWorkDataSource: WeatherNetWorkDataSource

    ): WeatherURepository {

    private val _fetchCurrentWeather = MutableLiveData<CurrentWeather>()

    private val fetchCurrentWeather: LiveData<CurrentWeather>
        get() = _fetchCurrentWeather

    init {

        weatherNetWorkDataSource.downloadedCurrentWeather.observeForever{
           this._fetchCurrentWeather.postValue(it)

        }

    }

    private suspend fun initFetchCurrentWeather (location : String = "London"){
        weatherNetWorkDataSource.fetchCurrentWeather(location)
    }

    override suspend fun getCurrentWeather(location: String): LiveData<CurrentWeather> {

        return withContext(Dispatchers.IO){
            initFetchCurrentWeather(location)
            return@withContext  fetchCurrentWeather
        }

    }
}