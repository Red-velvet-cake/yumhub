package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class CaloriesDto(
    @SerializedName("confidenceRange95Percent")
    val confidenceRange95Percent: ConfidenceRange95PercentDto? = null,
    @SerializedName("standardDeviation")
    val standardDeviation: Double? = null,
    @SerializedName("unit")
    val unit: String? = null,
    @SerializedName("value")
    val value: Double? = null
)