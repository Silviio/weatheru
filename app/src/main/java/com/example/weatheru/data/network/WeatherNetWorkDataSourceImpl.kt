package com.example.weatheru.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.weatheru.data.api.WeatherstackApi
import com.example.weatheru.data.entity.CurrentWeather
import com.example.weatheru.internal.exception.NoConnectivityException

class WeatherNetWorkDataSourceImpl(private val  weatherstackApi: WeatherstackApi ) : WeatherNetWorkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeather>()

    override val downloadedCurrentWeather: LiveData<CurrentWeather>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String) {

        try {

            val fetchedCurrentWeather = weatherstackApi.getCurrentWeatherAsync(location).await()

            _downloadedCurrentWeather.postValue(fetchedCurrentWeather.current)

        } catch (e: NoConnectivityException){
            Log.e("Connectivity", "No internet connection.", e)
        }
    }
}