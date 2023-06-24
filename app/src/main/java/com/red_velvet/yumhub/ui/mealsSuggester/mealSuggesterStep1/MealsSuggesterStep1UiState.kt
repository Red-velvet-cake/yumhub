package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep1

import com.red_velvet.yumhub.ui.base.BaseUiState

data class MealsSuggesterStep1UiState(
    val isLoading: Boolean = true,
    val gender: String = "Male",
    val activityLevel: String = "",
):BaseUiState()