package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.local.entities.HealthyRecipeDatabaseDto
import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity

fun HealthyRecipeDatabaseDto.toHealthyRecipeEntity(): HealthyRecipeEntity {
    return HealthyRecipeEntity(
        id = id,
        title = title,
        image = image
    )
}