package com.red_velvet.yumhub.ui.plannedMeals

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter


class PlannedMealsAdapter(
    items: List<PlannedMealsUiState.MealUiState>,
    listener: PlannedMealsInteractionListener
) : BaseAdapter<PlannedMealsUiState.MealUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_planned_meal
}