package com.red_velvet.repository.resources


import com.google.gson.annotations.SerializedName

data class CaloriesResource(
    @SerializedName("confidenceRange95Percent")
    val confidenceRange95Percent: com.red_velvet.repository.resources.ConfidenceRange95PercentResource? = null,
    @SerializedName("standardDeviation")
    val standardDeviation: Double? = null,
    @SerializedName("unit")
    val unit: String? = null,
    @SerializedName("value")
    val value: Double? = null
)