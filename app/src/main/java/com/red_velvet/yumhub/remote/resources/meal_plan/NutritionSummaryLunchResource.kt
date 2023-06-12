package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class NutritionSummaryLunchResource(
    @SerializedName("nutrients")
    val nutrientResources: List<com.red_velvet.yumhub.remote.resources.meal_plan.NutrientResource>? = listOf()
)