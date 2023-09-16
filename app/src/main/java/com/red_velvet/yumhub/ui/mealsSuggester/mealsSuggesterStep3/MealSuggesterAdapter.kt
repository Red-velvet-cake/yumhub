package com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.BaseInteractionListener
import com.red_velvet.yumhub.ui.mealsSuggester.MealsSuggesterStep1UiState

class MealSuggesterAdapter(
    meals: List<MealsSuggesterStep1UiState.SuggestedMeals>,
    listener: BaseInteractionListener
): BaseAdapter<MealsSuggesterStep1UiState.SuggestedMeals>(listener = listener, items = meals) {
    override val layoutId: Int = R.layout.item_meal_suggested
}