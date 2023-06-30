package com.red_velvet.yumhub.ui.plannedMeals

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface PlannedMealsInteractionListener : BaseInteractionListener {

    fun onMealClicked(id: Int)

}