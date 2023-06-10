package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.local.entities.QuickRecipeDatabaseDto
import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity

fun QuickRecipeEntity.toQuickRecipeDto(): QuickRecipeDatabaseDto {
    return QuickRecipeDatabaseDto(
        id = this.id,
        title = this.title,
        image = this.image,
        cookingMinutes = this.cookingMinutes
    )
}