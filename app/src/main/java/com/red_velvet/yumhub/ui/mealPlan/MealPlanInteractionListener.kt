package com.red_velvet.yumhub.ui.mealPlan

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface MealPlanInteractionListener : BaseInteractionListener {

    fun onDaySelected(timestamp: Int)

    fun onPageChanged(position: Int)
}