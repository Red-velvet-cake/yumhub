package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class MeasuresDto(
    @SerializedName("metric")
    val metric: MetricDto? = null,
    @SerializedName("us")
    val us: UsDto? = null
)