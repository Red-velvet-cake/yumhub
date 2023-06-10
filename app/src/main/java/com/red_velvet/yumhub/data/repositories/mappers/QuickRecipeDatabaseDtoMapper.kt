package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.local.entities.QuickRecipeDatabaseDto
import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity


fun QuickRecipeDatabaseDto.toQuickRecipeDto(): QuickRecipeEntity {
    return QuickRecipeEntity(
        id = id,
        title = title,
        image = image,
        cookingMinutes = cookingMinutes
    )
}