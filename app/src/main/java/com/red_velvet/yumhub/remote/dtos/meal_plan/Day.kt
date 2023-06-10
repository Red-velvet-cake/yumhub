package com.red_velvet.yumhub.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("date")
    val date: Int? = 0,
    @SerializedName("day")
    val day: String? = "",
    @SerializedName("items")
    val items: List<com.red_velvet.yumhub.remote.dtos.meal_plan.Item>? = listOf(),
    @SerializedName("nutritionSummary")
    val nutritionSummary: com.red_velvet.yumhub.remote.dtos.meal_plan.NutritionSummary? = com.red_velvet.yumhub.remote.dtos.meal_plan.NutritionSummary(),
    @SerializedName("nutritionSummaryBreakfast")
    val nutritionSummaryBreakfast: com.red_velvet.yumhub.remote.dtos.meal_plan.NutritionSummaryBreakfast? = com.red_velvet.yumhub.remote.dtos.meal_plan.NutritionSummaryBreakfast(),
    @SerializedName("nutritionSummaryDinner")
    val nutritionSummaryDinner: com.red_velvet.yumhub.remote.dtos.meal_plan.NutritionSummaryDinner? = com.red_velvet.yumhub.remote.dtos.meal_plan.NutritionSummaryDinner(),
    @SerializedName("nutritionSummaryLunch")
    val nutritionSummaryLunch: com.red_velvet.yumhub.remote.dtos.meal_plan.NutritionSummaryLunch? = com.red_velvet.yumhub.remote.dtos.meal_plan.NutritionSummaryLunch()
)