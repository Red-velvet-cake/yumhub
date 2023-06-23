package com.red_velvet.yumhub.ui.add_to_meal_plan

interface OnChooseMealTimeListener {

    fun onChooseMealPlanTime(slot: Int)

    fun onAddRecipeToMealPlan()

    fun onUpdateSelectedDate(year: Int, month: Int, dayOfMonth: Int)

}