package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.remote.dtos.meal_plan.AddMealDto
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.Value
import com.red_velvet.yumhub.domain.models.MealPlanEntity

fun MealPlanEntity.toAddMealPlan():AddMealDto{
    return AddMealDto(
        date = timestamp,
        position = position,
        slot = slot,
        type = type,
        value = Value(id = id, imageType = imageType,title = title, servings = servings,)
    )
}