package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.local.entities.MealPlanDatabaseDto
import com.red_velvet.yumhub.domain.models.MealPlanEntity

fun MealPlanDatabaseDto.toMealPlanEntity(): MealPlanEntity{
    return  MealPlanEntity(
        id = id,
        position = position,
        slot = slot,
        title = title,
        imageType = imageType,
        type = type,
        servings = servings,
        timestamp = timestamp
    )
}