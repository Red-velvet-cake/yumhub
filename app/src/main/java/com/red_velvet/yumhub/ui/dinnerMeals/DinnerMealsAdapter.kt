package com.red_velvet.yumhub.ui.dinnerMeals

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.mealPlan.MealPlanInteractionListener
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiState


class DinnerMealsAdapter(
    items: List<MealPlanUiState.MealUiState>,
    listener: MealPlanInteractionListener
) : BaseAdapter<MealPlanUiState.MealUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_planned_meal
}