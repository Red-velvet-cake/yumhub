package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.local.entities.MealPlanLocalDto

fun MealPlanLocalDto.toMealPlanDto(): com.red_velvet.yumhub.remote.dtos.meal_plan.AddMealDto {
    return com.red_velvet.yumhub.remote.dtos.meal_plan.AddMealDto(
        date = timestamp.toInt().orZero(),
        position = position.orZero(),
        slot = slot.orZero(),
        type = type.orEmpty(),
        value = com.red_velvet.yumhub.remote.dtos.meal_plan.Value(
            id.orZero(),
            imageType.orEmpty(),
            servings.orZero(),
            title.orEmpty()
        )
    )
}

