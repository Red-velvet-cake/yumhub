package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep1

sealed interface MealsSuggesterStep1UiEffect {
    data class ClickOnGenderSelector(val gender: String): MealsSuggesterStep1UiEffect
    data class ClickOnActivityLevelSelector(val activityLevel: String): MealsSuggesterStep1UiEffect
    object OnNextClicked:MealsSuggesterStep1UiEffect
}