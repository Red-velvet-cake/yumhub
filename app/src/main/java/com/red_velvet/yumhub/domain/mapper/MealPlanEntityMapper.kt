package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.Item

fun Item.toEntity(timesStamp: Long): MealPlanEntity {
    return MealPlanEntity(
        id = this.id ?: 0,
        position = this.position ?: 0,
        slot = this.slot ?: 1,
        type = this.type ?: "",
        imageType = this.value?.imageType ?: "",
        servings = this.value?.servings ?: 0,
        title = this.value?.title ?: "",
        timestamp = timesStamp
    )
}