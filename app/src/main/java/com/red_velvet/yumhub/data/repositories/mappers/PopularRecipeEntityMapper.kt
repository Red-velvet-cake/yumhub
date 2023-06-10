package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.local.entities.PopularRecipeDatabaseDto
import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity

fun PopularRecipeEntity.toPopularRecipeDto(): PopularRecipeDatabaseDto {
    return PopularRecipeDatabaseDto(
        id = this.id,
        title = this.title,
        image = this.image,
    )
}