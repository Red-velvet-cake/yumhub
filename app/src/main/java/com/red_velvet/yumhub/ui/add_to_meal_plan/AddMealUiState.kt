package com.red_velvet.yumhub.ui.add_to_meal_plan

import com.red_velvet.yumhub.domain.models.MealPlanEntity

data class AddMealUiState(
    val slot: Int = 0,
    val timeStamp: Long = 0
)

fun AddMealUiState.toEntity(): MealPlanEntity {
    return MealPlanEntity(
        slot = slot,
        timestamp = timeStamp
    )
}
