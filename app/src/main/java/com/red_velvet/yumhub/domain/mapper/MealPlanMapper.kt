package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.domain.models.MealPlan

fun MealPlanEntity.toMealPlan():MealPlan{
    return MealPlan(
        id = this.id,
        position = this.position,
        slot = this.slot,
        type = this.type,
        imageType = this.imageType,
        servings = this.servings,
        title = this.title,
        timestamp = this.timestamp
    )
}