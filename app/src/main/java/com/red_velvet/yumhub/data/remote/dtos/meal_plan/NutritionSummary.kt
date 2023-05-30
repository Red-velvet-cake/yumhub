package com.red_velvet.yumhub.data.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class NutritionSummary(
    @SerializedName("nutrients")
    val nutrients: List<Nutrient?>? = null
)