package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.AddMealDto
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.Value
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero

fun MealPlanEntity.toMealPlanDto(): AddMealDto {
    return AddMealDto(
        date = timestamp.toInt().orZero(),
        position = position.orZero(),
        slot = slot.orZero(),
        type = type.orEmpty(),
        value = Value(id.orZero(), imageType.orEmpty(), servings.orZero(), title.orEmpty())
    )
}

