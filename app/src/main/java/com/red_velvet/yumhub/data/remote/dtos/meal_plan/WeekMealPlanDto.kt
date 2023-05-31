package com.red_velvet.yumhub.data.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class WeekMealPlanDto(
    @SerializedName("days")
    val days: List<Day>? = listOf()
)