package com.kobito.sample.ui.weather.current

import com.kobito.sample.data.provider.UnitProvider
import com.kobito.sample.data.repository.ForecastRepository
import com.kobito.sample.internal.lazyDeffered
import com.kobito.sample.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeffered {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }
}
