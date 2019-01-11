package com.kobito.sample.data.network.response

import com.google.gson.annotations.SerializedName
import com.kobito.sample.data.db.entity.CurrentWeatherEntry
import com.kobito.sample.data.db.entity.WeatherLocation

data class CurrentWeatherResponse(
    val location: WeatherLocation,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)