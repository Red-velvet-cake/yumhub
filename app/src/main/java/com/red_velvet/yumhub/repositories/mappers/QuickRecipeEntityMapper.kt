package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.local.entities.QuickRecipeLocalDto

fun QuickRecipeEntity.toLocalDto(): QuickRecipeLocalDto {
    return QuickRecipeLocalDto(
        id = this.id,
        title = this.title,
        image = this.image,
        cookingMinutes = this.cookingMinutes
    )
}