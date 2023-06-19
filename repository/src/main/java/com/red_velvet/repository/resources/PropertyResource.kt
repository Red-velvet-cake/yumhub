package com.red_velvet.repository.resources


import com.google.gson.annotations.SerializedName

data class PropertyResource(
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("unit")
    val unit: String? = null
)