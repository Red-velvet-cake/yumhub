package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.local.entities.PopularRecipeLocalDto

fun PopularRecipeEntity.toLocalDto(): PopularRecipeLocalDto {
    return PopularRecipeLocalDto(
        id = this.id,
        title = this.title,
        image = this.image,
    )
}