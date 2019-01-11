package com.kobito.sample.ui.weather.current

import androidx.lifecycle.ViewModel
import com.kobito.sample.data.provider.UnitProvider
import com.kobito.sample.data.repository.ForecastRepository
import com.kobito.sample.internal.UnitSystem
import com.kobito.sample.internal.lazyDeffered

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeffered {
        forecastRepository.getCurrentWeather(isMetric)
    }

    val weatherLocation by lazyDeffered {
        forecastRepository.getWeatherLocation()
    }
}
