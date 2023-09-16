package com.red_velvet.yumhub.ui.plannedMeals

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiState

data class PlannedMealsUiState(
    val meals: List<MealUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: ErrorUIState? = null,
) : BaseUiState {

    data class MealUiState(
        val id: Int,
        val name: String,
        val description: String,
        val slot: Int,
        val imageUrl: String,
    )

}

fun MealPlanUiState.MealUiState.toPlannedMealUiState() = PlannedMealsUiState.MealUiState(
    id = id,
    name = name,
    description = description,
    slot = slot,
    imageUrl = imageUrl,
)

fun List<MealPlanUiState.MealUiState>.toPlannedMealUiState() = map { it.toPlannedMealUiState() }
