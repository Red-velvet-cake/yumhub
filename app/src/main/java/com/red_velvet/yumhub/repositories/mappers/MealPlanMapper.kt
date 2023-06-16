package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.MealPlanEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.local.entities.MealPlanLocalDto

fun MealPlanLocalDto.toEntity(): MealPlanEntity {
    return MealPlanEntity(
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