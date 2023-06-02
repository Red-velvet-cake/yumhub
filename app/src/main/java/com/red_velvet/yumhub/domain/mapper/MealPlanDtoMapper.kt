package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.AddMealDto
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.Value

fun MealPlanEntity.toMealPlanDto():AddMealDto{
    return AddMealDto(
        date = this.timestamp.toInt(),
        position = this.position,
        slot = this.slot,
        type = this.type,
        value = Value(this.id,this.imageType,this.servings,this.title)
    )
}

