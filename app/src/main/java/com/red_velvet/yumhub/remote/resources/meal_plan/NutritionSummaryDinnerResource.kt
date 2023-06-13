package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class NutritionSummaryDinnerResource(
    @SerializedName("nutrients")
    val nutrientResources: List<NutrientResource>? = listOf()
)