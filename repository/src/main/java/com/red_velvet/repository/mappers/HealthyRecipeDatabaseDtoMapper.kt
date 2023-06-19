package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.repository.entities.HealthyRecipeLocalDto

internal fun List<HealthyRecipeLocalDto>.toEntity(): List<HealthyRecipeEntity> {
    return this.map {
        com.red_velvet.domain.models.recipes.HealthyRecipeEntity(
            id = it.id,
            title = it.title,
            image = it.image
        )
    }
}