package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.local.entities.QuickRecipeLocalDto


fun List<QuickRecipeLocalDto>.toEntity(): List<QuickRecipeEntity> {
    return this.map {
        QuickRecipeEntity(
            id = it.id,
            title = it.title,
            image = it.image,
            cookingMinutes = it.cookingMinutes
        )
    }
}