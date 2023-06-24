package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep1

import com.red_velvet.yumhub.ui.base.BaseUiState

data class MealsSuggesterStep2UiState(
    val goal: String = "",
    val weight: Int = 0 ,
    val tall: Int = 0,
    val age: Int = 0
):BaseUiState()