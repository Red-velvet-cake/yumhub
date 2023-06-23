package com.red_velvet.yumhub.ui.add_to_meal_plan

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface AddToMealPlanUiEffect : BaseUIEffect {

    object InvalidInput : AddToMealPlanUiEffect
}