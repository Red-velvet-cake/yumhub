package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class MeasuresDto(
    @SerializedName("metric")
    val metric: com.red_velvet.yumhub.remote.resources.MetricDto? = null,
    @SerializedName("us")
    val us: com.red_velvet.yumhub.remote.resources.UsDto? = null
)