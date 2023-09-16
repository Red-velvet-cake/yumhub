package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.local.entities.HealthyRecipeLocalDto

fun List<HealthyRecipeLocalDto>.toEntity(): List<HealthyRecipeEntity> {
    return this.map {
        HealthyRecipeEntity(
            id = it.id,
            title = it.title,
            image = it.image
        )
    }
}