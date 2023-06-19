package com.red_velvet.repository.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class WeekMealPlanResource(
    @SerializedName("days")
    val dayResources: List<com.red_velvet.repository.resources.meal_plan.DayResource>? = listOf()
)