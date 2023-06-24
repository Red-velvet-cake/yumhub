package com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.BaseInteractionListener

class MealSuggesterAdapter(
    meals: List<MealsSuggesterStep3UiState.SuggestedMeals>,
    listener: BaseInteractionListener
): BaseAdapter<MealsSuggesterStep3UiState.SuggestedMeals>(listener = listener, items = meals) {
    override val layoutId: Int = R.layout.item_meal_suggested
}