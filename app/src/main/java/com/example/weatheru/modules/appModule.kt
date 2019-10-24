package com.example.weatheru.modules

import com.example.weatheru.data.api.WeatherstackApi
import com.example.weatheru.data.network.ConnectivityInterceptor
import com.example.weatheru.data.network.ConnectivityInterceptorImpl
import com.example.weatheru.data.network.WeatherNetWorkDataSource
import com.example.weatheru.data.network.WeatherNetWorkDataSourceImpl
import com.example.weatheru.data.network.config.NetworkConfig.API_URL
import com.example.weatheru.data.network.interceptor.AuthInterceptor
import com.example.weatheru.data.repository.WeatherURepository
import com.example.weatheru.data.repository.WeatherURepositoryImpl
import com.example.weatheru.ui.weather.viewmodel.CurrentWeatherViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


val appModule = module {

    single<ConnectivityInterceptor> {ConnectivityInterceptorImpl(context = get())}
    single<WeatherNetWorkDataSource> {WeatherNetWorkDataSourceImpl( get() ) }

    single<WeatherURepository> { WeatherURepositoryImpl(get())  }

    viewModel { CurrentWeatherViewModel(get()) }

    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideApiWeatherstack(get()) }

    single { provideRetrofit(get()) }

}

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(API_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
    }


    fun provideApiWeatherstack(retrofit: Retrofit): WeatherstackApi = retrofit.create(WeatherstackApi::class.java)