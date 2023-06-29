package com.red_velvet.yumhub.ui.mealPlan

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed class MealPlanUiEffect : BaseUIEffect {
    data class ShowMealDetails(val mealId: Int) : MealPlanUiEffect()

    object ShowDatePicker : MealPlanUiEffect()
}