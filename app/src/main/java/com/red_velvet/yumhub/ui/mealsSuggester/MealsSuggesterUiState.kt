package com.red_velvet.yumhub.ui.mealsSuggester

import com.red_velvet.yumhub.ui.base.BaseUiState

data class MealsSuggesterUiState(
    val isLoading: Boolean = true,
    val gender: String = "Male",
    val activityLevel: String = "",
):BaseUiState()