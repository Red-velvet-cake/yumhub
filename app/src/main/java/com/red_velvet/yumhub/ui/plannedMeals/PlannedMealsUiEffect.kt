package com.red_velvet.yumhub.ui.plannedMeals

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface PlannedMealsUiEffect : BaseUIEffect {

    data class ShowMealDetails(val id: Int) : PlannedMealsUiEffect
}