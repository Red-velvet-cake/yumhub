package com.red_velvet.yumhub.domain.models


data class MealPlan(
    val id: Int,
    val slot: Int,
    val type: String,
    val imageType: String,
    val title: String,
    val timestamp: Long
)
