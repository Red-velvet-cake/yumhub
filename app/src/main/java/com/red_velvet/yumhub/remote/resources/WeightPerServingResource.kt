package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class WeightPerServingResource(
    @SerializedName("amount")
    val amount: Int? = null,
    @SerializedName("unit")
    val unit: String? = null
)