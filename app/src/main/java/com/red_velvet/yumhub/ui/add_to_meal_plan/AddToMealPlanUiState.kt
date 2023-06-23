package com.red_velvet.yumhub.ui.add_to_meal_plan

import com.red_velvet.yumhub.ui.base.BaseUiState

data class AddToMealPlanUiState(
    val addMealUiState: AddMealUiState = AddMealUiState(),
    val isLoading: Boolean = false
) : BaseUiState
