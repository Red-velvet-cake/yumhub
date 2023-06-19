package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.IngredientSearchEntity
import com.red_velvet.repository.resources.ingredient.IngredientSearchResultResource
import com.red_velvet.repository.utils.orZero

internal fun IngredientSearchResultResource.toIngredientSearchResult(): IngredientSearchEntity {
    return IngredientSearchEntity(
        id = id.orZero(),
        name = name.orEmpty(),
        image = image.orEmpty(),
    )
}

