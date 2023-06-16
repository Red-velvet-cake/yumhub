package com.red_velvet.yumhub.data.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("position")
    val position: Int? = null,
    @SerializedName("slot")
    val slot: Int? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("value")
    val value: Value? = null
)