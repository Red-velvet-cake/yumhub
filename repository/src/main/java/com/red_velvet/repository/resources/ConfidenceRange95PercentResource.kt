package com.red_velvet.repository.resources


import com.google.gson.annotations.SerializedName

data class ConfidenceRange95PercentResource(
    @SerializedName("max")
    val max: Double? = null,
    @SerializedName("min")
    val min: Double? = null
)