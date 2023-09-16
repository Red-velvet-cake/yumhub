package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.IngredientSearchEntity
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientSearchResultResource

fun IngredientSearchResultResource.toIngredientSearchResult(): IngredientSearchEntity {
    return IngredientSearchEntity(
        id = id.orZero(),
        name = name.orEmpty(),
        image = image.orEmpty(),
    )
}

