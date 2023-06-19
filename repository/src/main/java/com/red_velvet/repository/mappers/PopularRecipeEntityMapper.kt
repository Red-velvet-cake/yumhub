package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.repository.entities.PopularRecipeLocalDto

internal fun PopularRecipeEntity.toLocalDto(): PopularRecipeLocalDto {
    return PopularRecipeLocalDto(
        id = this.id,
        title = this.title,
        image = this.image,
    )
}