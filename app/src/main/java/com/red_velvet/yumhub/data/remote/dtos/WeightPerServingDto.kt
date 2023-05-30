package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class WeightPerServingDto(
    @SerializedName("amount")
    val amount: Int? = null,
    @SerializedName("unit")
    val unit: String? = null
)