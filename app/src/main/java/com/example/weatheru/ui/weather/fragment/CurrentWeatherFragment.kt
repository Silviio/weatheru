package com.example.weatheru.ui.weather.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide


import com.example.weatheru.R
import com.example.weatheru.data.entity.CurrentWeather
import com.example.weatheru.ui.weather.viewmodel.CurrentWeatherViewModel
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel


class CurrentWeatherFragment : Fragment() {

    private val currentWeatherViewModel : CurrentWeatherViewModel by viewModel()

    private lateinit var shimmerFrameLayout: ShimmerFrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.current_weather_fragment, container, false)

        shimmerFrameLayout = view!!.findViewById(R.id.shimmer_view_container)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        GlobalScope.launch (Dispatchers.Main){

            currentWeatherViewModel.getCurrentWeather("London").observe(this@CurrentWeatherFragment, Observer {

                updateDateStatusBar(it.observationTime)
                updateUI(it)

            })

            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.visibility = View.GONE
        }

    }

    private fun updateDateStatusBar(sTime : String){

        (activity as? AppCompatActivity)?.supportActionBar?.title ="London"
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = sTime

    }

    private fun updateUI(currentWeather: CurrentWeather){

        textView_feels_like_temperature_placeholder.text = "Feels like ${currentWeather.feelslike}"
        textView_temperature_placeholder.text = "${currentWeather.feelslike}.0°C"
        textView_wind_placeholder.text = "Wind: ${currentWeather.windDir}, ${currentWeather.windSpeed} kph"
        textView_visibility_placeholder.text = "Visibility: ${currentWeather.visibility} km"
        textView_precipitation_placeholder.text = "Preciptiation: ${currentWeather.precip} mm"
        textView_condition_placeholder.text = " ${currentWeather.weatherDescriptions[0]}"

        Glide.with(this@CurrentWeatherFragment)
            .load(currentWeather.weatherIcons[0])
            .into(imageView_condition_icon_placeholder)

    }
}
