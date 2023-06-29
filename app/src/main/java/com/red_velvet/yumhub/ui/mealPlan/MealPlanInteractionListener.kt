package com.red_velvet.yumhub.ui.mealPlan

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface MealPlanInteractionListener : BaseInteractionListener {

    fun onCalendarDaySelected(timestamp: Int)

    fun onMealClicked(meal: MealPlanUiState.MealUiState)

}