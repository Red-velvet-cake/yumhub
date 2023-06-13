package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.local.entities.MealPlanLocalDto
import com.red_velvet.yumhub.remote.resources.meal_plan.ItemResource

fun ItemResource.toEntity(timesStamp: Long): MealPlanLocalDto {
    return MealPlanLocalDto(
        id = this.id.orZero(),
        position = this.position.orZero(),
        slot = this.slot.orZero(),
        type = this.type.orEmpty(),
        imageType = this.valueResource?.imageType.orEmpty(),
        servings = this.valueResource?.servings.orZero(),
        title = this.valueResource?.title.orEmpty(),
        timestamp = timesStamp.orZero()
    )
}