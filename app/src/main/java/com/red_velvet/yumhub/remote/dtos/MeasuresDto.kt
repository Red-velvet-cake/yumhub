package com.red_velvet.yumhub.remote.dtos


import com.google.gson.annotations.SerializedName

data class MeasuresDto(
    @SerializedName("metric")
    val metric: com.red_velvet.yumhub.remote.dtos.MetricDto? = null,
    @SerializedName("us")
    val us: com.red_velvet.yumhub.remote.dtos.UsDto? = null
)