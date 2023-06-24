package com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3

sealed interface MealsSuggesterStep3UiEffect {
    data class ClickOnGoalSelector(val goal: String): MealsSuggesterStep3UiEffect
}