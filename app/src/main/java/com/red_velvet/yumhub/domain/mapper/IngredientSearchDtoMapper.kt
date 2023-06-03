package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchResultDto
import com.red_velvet.yumhub.domain.models.IngredientSearch
import com.red_velvet.yumhub.domain.utils.orZero

fun IngredientSearchResultDto.toIngredientSearchResult(): IngredientSearch {
    return IngredientSearch(
        id = id.orZero(),
        name = name.orEmpty(),
        image = image.orEmpty(),
    )
}

