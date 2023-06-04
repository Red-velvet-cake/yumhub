package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.Item
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero

fun Item.toEntity(timesStamp: Long): MealPlanEntity {
    return MealPlanEntity(
        id = this.id.orZero(),
        position = this.position.orZero(),
        slot = this.slot.orZero(),
        type = this.type.orEmpty(),
        imageType = this.value?.imageType.orEmpty(),
        servings = this.value?.servings.orZero(),
        title = this.value?.title.orEmpty(),
        timestamp = timesStamp.orZero()
    )
}