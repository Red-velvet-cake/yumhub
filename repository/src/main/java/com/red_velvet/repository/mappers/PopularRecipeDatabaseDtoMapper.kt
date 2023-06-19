package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.repository.entities.PopularRecipeLocalDto


internal fun List<PopularRecipeLocalDto>.toEntity(): List<PopularRecipeEntity> {
    return this.map {
        com.red_velvet.domain.models.recipes.PopularRecipeEntity(
            id = it.id,
            title = it.title,
            image = it.image
        )
    }
}