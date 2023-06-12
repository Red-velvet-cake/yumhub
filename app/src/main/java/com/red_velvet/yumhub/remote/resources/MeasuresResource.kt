package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class MeasuresResource(
    @SerializedName("metric")
    val metric: com.red_velvet.yumhub.remote.resources.MetricResource? = null,
    @SerializedName("us")
    val us: com.red_velvet.yumhub.remote.resources.UsResource? = null
)