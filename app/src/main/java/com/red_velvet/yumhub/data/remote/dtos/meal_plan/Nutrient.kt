package com.red_velvet.yumhub.data.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class Nutrient(
    @SerializedName("amount")
    val amount: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("percentOfDailyNeeds")
    val percentOfDailyNeeds: Int? = null,
    @SerializedName("unit")
    val unit: String? = null
)