package com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3

import com.red_velvet.yumhub.ui.base.BaseInteractionListener
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiState

interface SuggestedMealsInteractionListener:BaseInteractionListener {
    fun onMealClick(item:MealsSuggesterStep1UiState.SuggestedMeals)
}