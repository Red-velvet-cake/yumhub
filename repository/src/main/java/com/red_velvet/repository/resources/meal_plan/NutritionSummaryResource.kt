package com.red_velvet.repository.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class NutritionSummaryResource(
    @SerializedName("nutrients")
    val nutrientResources: List<com.red_velvet.repository.resources.meal_plan.NutrientResource?>? = null
)