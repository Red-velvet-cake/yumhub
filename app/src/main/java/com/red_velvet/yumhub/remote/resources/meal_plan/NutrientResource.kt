package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class NutrientResource(
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("percentOfDailyNeeds")
    val percentOfDailyNeeds: Int? = null,
    @SerializedName("unit")
    val unit: String? = null
)