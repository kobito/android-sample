package com.kobito.sample.ui.weather.future.detail

import com.kobito.sample.data.provider.UnitProvider
import com.kobito.sample.data.repository.ForecastRepository
import com.kobito.sample.internal.lazyDeffered
import com.kobito.sample.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeffered {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}
