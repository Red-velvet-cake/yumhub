package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep2

sealed interface MealsSuggesterStep2UiEffect {
    data class ClickOnGoalSelector(val goal: String): MealsSuggesterStep2UiEffect
}