package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class WeekMealPlanResource(
    @SerializedName("days")
    val dayResources: List<DayResource>? = listOf()
)