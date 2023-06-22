package com.red_velvet.yumhub.domain.models

import com.red_velvet.yumhub.remote.resources.meal_plan.AddMealResource
import com.red_velvet.yumhub.remote.resources.meal_plan.ValueResource

data class MealPlanEntity(
    val slot: Int = 0,
    val timestamp: Long = 0,
    val id: Int
)

fun MealPlanEntity.toMealPlanResource(): AddMealResource {
    return AddMealResource(
        date = timestamp,
        slot = slot,
        valueResource = ValueResource(id = id)
    )
}
