package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.local.entities.HealthyRecipeLocalDto

fun HealthyRecipeEntity.toLocalDto(): HealthyRecipeLocalDto {
    return HealthyRecipeLocalDto(
        id = this.id,
        title = this.title,
        image = this.image,
    )
}
