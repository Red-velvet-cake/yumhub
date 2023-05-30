package com.red_velvet.yumhub.data.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("date")
    val date: Int? = 0,
    @SerializedName("day")
    val day: String? = "",
    @SerializedName("items")
    val items: List<Item>? = listOf(),
    @SerializedName("nutritionSummary")
    val nutritionSummary: NutritionSummary? = NutritionSummary(),
    @SerializedName("nutritionSummaryBreakfast")
    val nutritionSummaryBreakfast: NutritionSummaryBreakfast? = NutritionSummaryBreakfast(),
    @SerializedName("nutritionSummaryDinner")
    val nutritionSummaryDinner: NutritionSummaryDinner? = NutritionSummaryDinner(),
    @SerializedName("nutritionSummaryLunch")
    val nutritionSummaryLunch: NutritionSummaryLunch? = NutritionSummaryLunch()
)