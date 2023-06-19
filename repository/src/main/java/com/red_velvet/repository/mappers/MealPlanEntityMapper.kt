package com.red_velvet.repository.mappers


import com.red_velvet.repository.entities.MealPlanLocalDto
import com.red_velvet.repository.resources.meal_plan.ItemResource
import com.red_velvet.repository.utils.orZero


internal fun ItemResource.toEntity(timesStamp: Long): MealPlanLocalDto {
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