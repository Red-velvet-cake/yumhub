package com.red_velvet.yumhub.data.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class AddMealDto(
    @SerializedName("date")
    val date: Int? = 0,
    @SerializedName("position")
    val position: Int? = 0,
    @SerializedName("slot")
    val slot: Int? = 0,
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("value")
    val value: Value? = Value()
)