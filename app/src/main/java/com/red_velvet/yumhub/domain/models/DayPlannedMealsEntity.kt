package com.red_velvet.yumhub.domain.models

data class DayPlannedMealsEntity(
    val timestamp: Int,
    val dayOfWeek: String,
    val datOfMonth: String,
    val meals: List<PlannedMealEntity>
)
