package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.local.entities.MealPlanLocalDto
import com.red_velvet.yumhub.remote.resources.meal_plan.AddMealResource
import com.red_velvet.yumhub.remote.resources.meal_plan.MealPlanItemType

fun MealPlanLocalDto.toMealPlanDto(): AddMealResource {
    return AddMealResource(
        date = timestamp.orZero(),
        position = position.orZero(),
        slot = slot.orZero(),
        type = MealPlanItemType.RECIPE,
//        valueResource = ValueResource(
//            id.orZero(),
//            imageType.orEmpty(),
//            servings.orZero(),
//            title.orEmpty()
//        )
    )
}

