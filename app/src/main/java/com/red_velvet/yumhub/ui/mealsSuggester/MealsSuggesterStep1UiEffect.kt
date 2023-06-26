package com.red_velvet.yumhub.ui.mealsSuggester

import com.red_velvet.yumhub.ui.base.BaseUIEffect


sealed interface MealsSuggesterStep1UiEffect : BaseUIEffect {
    data class ClickOnGenderSelector(val gender: String) : MealsSuggesterStep1UiEffect
    data class ClickOnActivityLevelSelector(val activityLevel: String) : MealsSuggesterStep1UiEffect
    object OnNextClicked : MealsSuggesterStep1UiEffect

    data class ClickOnGoalSelector(val goal: String) : MealsSuggesterStep1UiEffect

}