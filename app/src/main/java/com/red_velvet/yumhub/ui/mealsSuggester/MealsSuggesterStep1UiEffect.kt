package com.red_velvet.yumhub.ui.mealsSuggester

import com.red_velvet.yumhub.ui.base.BaseUIEffect


sealed interface MealsSuggesterStep1UiEffect : BaseUIEffect {
    data class ClickOnGenderSelector(val gender: String) : MealsSuggesterStep1UiEffect
    data class ClickOnActivityLevelSelector(val activityLevel: Int) : MealsSuggesterStep1UiEffect
    data class OnNextClicked(val type: String) : MealsSuggesterStep1UiEffect
    data class ClickOnGoalSelector(val goal: String) : MealsSuggesterStep1UiEffect
    data class OnSelectItemRecipe(val itemRecipe: MealsSuggesterStep1UiState.SuggestedMeals,val calories: Int?): MealsSuggesterStep1UiEffect
    object OnEmptyFields : MealsSuggesterStep1UiEffect
}