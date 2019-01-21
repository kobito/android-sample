package com.kobito.sample.ui.base

import androidx.lifecycle.ViewModel
import com.kobito.sample.data.provider.UnitProvider
import com.kobito.sample.data.repository.ForecastRepository
import com.kobito.sample.internal.UnitSystem
import com.kobito.sample.internal.lazyDeffered

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeffered {
        forecastRepository.getWeatherLocation()
    }
}