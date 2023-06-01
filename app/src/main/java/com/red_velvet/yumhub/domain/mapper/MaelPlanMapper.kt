package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.domain.models.MealPlan

fun MealPlanEntity.toMealPlanMapper(): MealPlan {
    return MealPlan(
        id = this.id,
        slot = this.slot,
        type = this.type,
        imageType = this.imageType,
        title = this.title,
        timestamp = this.timestamp
    )
}