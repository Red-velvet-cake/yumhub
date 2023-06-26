package com.red_velvet.yumhub.ui.mealPlan

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class MealPlanUiState(
    val isLoading: Boolean = false,
    val error: ErrorUIState? = null
) : BaseUiState
