package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class MetricDto(
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("unitLong")
    val unitLong: String? = null,
    @SerializedName("unitShort")
    val unitShort: String? = null
)