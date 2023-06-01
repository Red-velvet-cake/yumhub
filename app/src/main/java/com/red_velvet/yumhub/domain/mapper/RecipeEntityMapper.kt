package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.RecipeEntity
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchResultDto

fun RecipeSearchResultDto.toEntity(
    type: String
): RecipeEntity {
    return RecipeEntity(
        id = id ?: 0,
        title = title ?: "",
        image = image ?: "",
        type = type ?: ""
    )
}