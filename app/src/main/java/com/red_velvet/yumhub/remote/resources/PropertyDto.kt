package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class PropertyDto(
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("unit")
    val unit: String? = null
)