package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class DayResource(
    @SerializedName("date")
    val date: Int? = 0,
    @SerializedName("day")
    val day: String? = "",
    @SerializedName("items")
    val itemResources: List<ItemResource>? = listOf(),
    @SerializedName("nutritionSummary")
    val nutritionSummaryResource: NutritionSummaryResource? = NutritionSummaryResource(),
    @SerializedName("nutritionSummaryBreakfast")
    val nutritionSummaryBreakfastResource: NutritionSummaryBreakfastResource? = NutritionSummaryBreakfastResource(),
    @SerializedName("nutritionSummaryDinner")
    val nutritionSummaryDinnerResource: NutritionSummaryDinnerResource? = NutritionSummaryDinnerResource(),
    @SerializedName("nutritionSummaryLunch")
    val nutritionSummaryLunchResource: NutritionSummaryLunchResource? = NutritionSummaryLunchResource()
)