package com.red_velvet.domain.models

data class MealPlanEntity(
    val id: Int,
    val position: Int,
    val slot: Int,
    val type: String,
    val imageType: String,
    val servings: Int,
    val title: String,
    val timestamp: Long
)
