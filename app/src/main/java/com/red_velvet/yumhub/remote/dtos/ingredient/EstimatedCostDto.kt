package com.red_velvet.yumhub.remote.dtos.ingredient


import com.google.gson.annotations.SerializedName

data class EstimatedCostDto(
    @SerializedName("unit")
    val unit: String? = null,
    @SerializedName("value")
    val value: Double? = null
)