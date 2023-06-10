package com.red_velvet.yumhub.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class Nutrient(
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("percentOfDailyNeeds")
    val percentOfDailyNeeds: Int? = null,
    @SerializedName("unit")
    val unit: String? = null
)