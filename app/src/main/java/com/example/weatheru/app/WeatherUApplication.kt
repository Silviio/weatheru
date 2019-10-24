package com.example.weatheru.app

import android.app.Application
import com.example.weatheru.modules.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherUApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@WeatherUApplication)
            modules(appModule)
        }

    }
}