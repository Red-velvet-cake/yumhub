package com.red_velvet.yumhub.remote.resources.ingredient


import com.google.gson.annotations.SerializedName

data class NutrientDto(
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("percentOfDailyNeeds")
    val percentOfDailyNeeds: Double? = null,
    @SerializedName("unit")
    val unit: String? = null
)