package com.kobito.sample.data.network.response

import com.google.gson.annotations.SerializedName
import com.kobito.sample.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)