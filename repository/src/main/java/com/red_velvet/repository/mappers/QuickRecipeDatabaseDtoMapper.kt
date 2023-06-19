package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.repository.entities.QuickRecipeLocalDto


internal fun List<QuickRecipeLocalDto>.toEntity(): List<QuickRecipeEntity> {
    return this.map {
        QuickRecipeEntity(
            id = it.id,
            title = it.title,
            image = it.image,
            cookingMinutes = it.cookingMinutes
        )
    }
}