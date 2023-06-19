package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.repository.entities.HealthyRecipeLocalDto

internal fun HealthyRecipeEntity.toLocalDto(): HealthyRecipeLocalDto {
    return HealthyRecipeLocalDto(
        id = this.id,
        title = this.title,
        image = this.image,
    )
}
