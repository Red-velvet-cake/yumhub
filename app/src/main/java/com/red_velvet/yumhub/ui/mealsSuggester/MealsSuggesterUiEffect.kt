package com.red_velvet.yumhub.ui.mealsSuggester

sealed interface MealsSuggesterUiEffect {
    data class ClickOnGenderSelector(val gender: String):MealsSuggesterUiEffect
    data class ClickOnActivityLevelSelector(val activityLevel: String): MealsSuggesterUiEffect
}