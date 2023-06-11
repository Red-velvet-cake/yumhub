package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.domain.models.IngredientSearchEntity
import com.red_velvet.yumhub.domain.utils.orZero

fun com.red_velvet.yumhub.remote.resources.ingredient.IngredientSearchResultDto.toIngredientSearchResult(): IngredientSearchEntity {
    return IngredientSearchEntity(
        id = id.orZero(),
        name = name.orEmpty(),
        image = image.orEmpty(),
    )
}

