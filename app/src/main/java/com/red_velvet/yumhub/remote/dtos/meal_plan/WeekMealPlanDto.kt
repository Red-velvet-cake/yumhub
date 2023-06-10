package com.red_velvet.yumhub.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class WeekMealPlanDto(
    @SerializedName("days")
    val days: List<com.red_velvet.yumhub.remote.dtos.meal_plan.Day>? = listOf()
)