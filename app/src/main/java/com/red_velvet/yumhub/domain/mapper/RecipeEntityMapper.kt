package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.local.entities.RecipeEntity
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchResultDto
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero

fun RecipeInformationDto.toEntity(
    type: String
): RecipeEntity {
    return RecipeEntity(
        id = id.orZero(),
        title = title.orEmpty(),
        image = image.orEmpty(),
        type = type.orEmpty(),
        imageType = imageType.orEmpty(),
        servings = servings.orZero()
    )
}