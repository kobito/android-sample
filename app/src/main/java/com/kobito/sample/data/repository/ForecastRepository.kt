package com.kobito.sample.data.repository

import androidx.lifecycle.LiveData
import com.kobito.sample.data.db.entity.WeatherLocation
import com.kobito.sample.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}