package com.red_velvet.repository.resources


import com.google.gson.annotations.SerializedName

data class MeasuresResource(
    @SerializedName("metric")
    val metric: com.red_velvet.repository.resources.MetricResource? = null,
    @SerializedName("us")
    val us: com.red_velvet.repository.resources.UsResource? = null
)