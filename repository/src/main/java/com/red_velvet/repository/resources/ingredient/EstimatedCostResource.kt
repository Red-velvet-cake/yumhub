package com.red_velvet.repository.resources.ingredient


import com.google.gson.annotations.SerializedName

data class EstimatedCostResource(
    @SerializedName("unit")
    val unit: String? = null,
    @SerializedName("value")
    val value: Double? = null
)