package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.domain.models.MealPlan
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero

fun MealPlanEntity.toMealPlan():MealPlan{
    return MealPlan(
        id = id.orZero(),
        position = position.orZero(),
        slot = slot.orZero(),
        type = type.orEmpty(),
        imageType = imageType.orEmpty(),
        servings = servings.orZero(),
        title = title.orEmpty(),
        timestamp = timestamp.orZero()
    )
}