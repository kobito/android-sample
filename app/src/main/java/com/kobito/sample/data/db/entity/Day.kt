package com.kobito.sample.data.db.entity

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Day(
    val avghumidity: Int,
    @SerializedName("avgtemp_c")
    val avgtempC: Int,
    @SerializedName("avgtemp_f")
    val avgtempF: Double,
    @SerializedName("avgvis_km")
    val avgvisKm: Int,
    @SerializedName("avgvis_miles")
    val avgvisMiles: Int,
    @Embedded(prefix = "condition_")
    val condition: Condition,
    @SerializedName("maxtemp_c")
    val maxtempC: Double,
    @SerializedName("maxtemp_f")
    val maxtempF: Double,
    @SerializedName("maxwind_kph")
    val maxwindKph: Double,
    @SerializedName("maxwind_mph")
    val maxwindMph: Double,
    @SerializedName("mintemp_c")
    val mintempC: Double,
    @SerializedName("mintemp_f")
    val mintempF: Double,
    @SerializedName("totalprecip_in")
    val totalprecipIn: Int,
    @SerializedName("totalprecip_mm")
    val totalprecipMm: Int,
    val uv: String
)