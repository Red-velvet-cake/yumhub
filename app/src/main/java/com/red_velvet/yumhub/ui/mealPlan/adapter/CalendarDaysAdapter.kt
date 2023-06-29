package com.red_velvet.yumhub.ui.mealPlan.adapter

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.mealPlan.MealPlanInteractionListener
import com.red_velvet.yumhub.ui.mealPlan.MealPlanUiState

class CalendarDaysAdapter(
    items: List<MealPlanUiState.DayPlannedMealsUiState>,
    listener: MealPlanInteractionListener
) : BaseAdapter<MealPlanUiState.DayPlannedMealsUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_calendar_day
}