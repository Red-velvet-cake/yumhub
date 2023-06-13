package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class MeasuresResource(
    @SerializedName("metric")
    val metric: MetricResource? = null,
    @SerializedName("us")
    val us: UsResource? = null
)