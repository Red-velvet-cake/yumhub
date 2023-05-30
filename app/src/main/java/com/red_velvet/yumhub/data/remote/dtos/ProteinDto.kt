package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class ProteinDto(
    @SerializedName("confidenceRange95Percent")
    val confidenceRange95Percent: ConfidenceRange95PercentDto? = ConfidenceRange95PercentDto(),
    @SerializedName("standardDeviation")
    val standardDeviation: Double? = 0.0,
    @SerializedName("unit")
    val unit: String? = "",
    @SerializedName("value")
    val value: Double? = 0.0
)