package com.kobito.sample.data.network.response

import com.google.gson.annotations.SerializedName
import com.kobito.sample.data.db.entity.WeatherLocation

data class FutureWeatherResponse(
    @SerializedName("forcast")
    val futureWeatherEntries: ForecastDaysContainer,
    val location: WeatherLocation
)