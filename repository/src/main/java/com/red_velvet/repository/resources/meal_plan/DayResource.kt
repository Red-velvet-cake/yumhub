package com.red_velvet.repository.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class DayResource(
    @SerializedName("date")
    val date: Int? = 0,
    @SerializedName("day")
    val day: String? = "",
    @SerializedName("items")
    val itemResources: List<com.red_velvet.repository.resources.meal_plan.ItemResource>? = listOf(),
    @SerializedName("nutritionSummary")
    val nutritionSummaryResource: com.red_velvet.repository.resources.meal_plan.NutritionSummaryResource? = com.red_velvet.repository.resources.meal_plan.NutritionSummaryResource(),
    @SerializedName("nutritionSummaryBreakfast")
    val nutritionSummaryBreakfastResource: com.red_velvet.repository.resources.meal_plan.NutritionSummaryBreakfastResource? = com.red_velvet.repository.resources.meal_plan.NutritionSummaryBreakfastResource(),
    @SerializedName("nutritionSummaryDinner")
    val nutritionSummaryDinnerResource: com.red_velvet.repository.resources.meal_plan.NutritionSummaryDinnerResource? = com.red_velvet.repository.resources.meal_plan.NutritionSummaryDinnerResource(),
    @SerializedName("nutritionSummaryLunch")
    val nutritionSummaryLunchResource: com.red_velvet.repository.resources.meal_plan.NutritionSummaryLunchResource? = com.red_velvet.repository.resources.meal_plan.NutritionSummaryLunchResource()
)