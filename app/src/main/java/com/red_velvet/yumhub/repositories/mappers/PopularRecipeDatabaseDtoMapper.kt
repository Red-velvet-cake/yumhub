package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.local.entities.PopularRecipeLocalDto


fun List<PopularRecipeLocalDto>.toEntity(): List<PopularRecipeEntity> {
    return this.map {
        PopularRecipeEntity(
            id = it.id,
            title = it.title,
            image = it.image
        )
    }
}