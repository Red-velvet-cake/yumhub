package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.local.entities.HealthyRecipeDatabaseDto
import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity

fun HealthyRecipeEntity.toHealthyRecipeDto(): HealthyRecipeDatabaseDto {
    return HealthyRecipeDatabaseDto(
        id = this.id,
        title = this.title,
        image = this.image,
    )
}
