package com.red_velvet.yumhub.ui.mealPlan

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class MealPlanUiState(
    val calendarDays: List<DayUiState> = emptyList(),
    val breakfastMeals: List<MealUiState> = emptyList(),
    val lunchMeals: List<MealUiState> = emptyList(),
    val dinnerMeals: List<MealUiState> = emptyList(),
    val selectedMealType: MealType = MealType.BREAKFAST,
    val isLoading: Boolean = false,
    val error: ErrorUIState? = null,
) : BaseUiState {

    data class DayUiState(
        val weekDay: String,
        val monthDay: String,
        val isSelected: Boolean = false,
    )

    data class MealUiState(
        val id: Int,
        val name: String,
        val description: String,
        val imageUrl: String,
    )

    enum class MealType {
        BREAKFAST,
        LUNCH,
        DINNER
    }
}
