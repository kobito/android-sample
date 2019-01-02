package com.kobito.sample.ui.weather.current

import androidx.lifecycle.ViewModel
import com.kobito.sample.data.repository.ForecastRepository
import com.kobito.sample.internal.UnitSystem
import com.kobito.sample.internal.lazyDeffered

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.METRIC // TODO: get from settings later
    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeffered {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
