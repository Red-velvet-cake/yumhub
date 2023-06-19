package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.MealPlanEntity
import com.red_velvet.repository.resources.meal_plan.AddMealResource
import com.red_velvet.repository.resources.meal_plan.ValueResource
import com.red_velvet.repository.utils.orZero

 internal fun MealPlanEntity.toMealPlanResource():AddMealResource{
    return AddMealResource(
        date = timestamp.orZero(),
        position = position.orZero(),
        slot = slot.orZero() ,
        type = type.orEmpty() ,
        valueResource = ValueResource(
            id.orZero(),
            imageType.orEmpty(),
            servings.orZero(),
            title.orEmpty()
        )
    )
}