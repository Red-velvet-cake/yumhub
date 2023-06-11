package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class ConfidenceRange95PercentDto(
    @SerializedName("max")
    val max: Double? = null,
    @SerializedName("min")
    val min: Double? = null
)