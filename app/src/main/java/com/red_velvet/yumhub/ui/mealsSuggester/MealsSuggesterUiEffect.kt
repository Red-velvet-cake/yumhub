package com.red_velvet.yumhub.ui.mealsSuggester

sealed interface MealsSuggesterUiEffect {
    data class clickOnGenderSelector(val gender: String):MealsSuggesterUiEffect
}