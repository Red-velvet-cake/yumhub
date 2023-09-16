package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.MealPlanEntity
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.local.entities.MealPlanLocalDto

fun MealPlanLocalDto.toEntity(): MealPlanEntity {
    return MealPlanEntity(
        slot = slot.orZero(),
        timestamp = timestamp.orZero(),
        id = id.orZero()
    )
}