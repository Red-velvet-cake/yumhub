package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.repository.entities.QuickRecipeLocalDto

internal fun QuickRecipeEntity.toLocalDto(): QuickRecipeLocalDto {
    return QuickRecipeLocalDto(
        id = this.id,
        title = this.title,
        image = this.image,
        cookingMinutes = this.cookingMinutes
    )
}