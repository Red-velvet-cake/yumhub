package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.local.entities.PopularRecipeDatabaseDto
import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity


fun PopularRecipeDatabaseDto.toPopularRecipeEntity(): PopularRecipeEntity {
    return PopularRecipeEntity(
        id = id,
        title = title,
        image = image
    )
}