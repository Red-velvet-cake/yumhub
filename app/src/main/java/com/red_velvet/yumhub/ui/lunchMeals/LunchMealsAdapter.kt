package com.red_velvet.yumhub.ui.lunchMeals

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.mealPlan.MealPlanInteractionListener
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiState


class LunchMealsAdapter(
    items: List<MealPlanUiState.MealUiState>,
    listener: MealPlanInteractionListener
) : BaseAdapter<MealPlanUiState.MealUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_planned_meal
}