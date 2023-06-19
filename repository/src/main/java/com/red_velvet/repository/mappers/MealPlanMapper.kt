package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.MealPlanEntity
import com.red_velvet.repository.entities.MealPlanLocalDto
import com.red_velvet.repository.utils.orZero
internal fun MealPlanLocalDto.toMealPlanEntity(): MealPlanEntity {
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