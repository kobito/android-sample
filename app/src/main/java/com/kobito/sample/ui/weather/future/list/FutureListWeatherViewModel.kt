package com.kobito.sample.ui.weather.future.list

import com.kobito.sample.data.provider.UnitProvider
import com.kobito.sample.data.repository.ForecastRepository
import com.kobito.sample.internal.lazyDeffered
import com.kobito.sample.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeffered {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}
