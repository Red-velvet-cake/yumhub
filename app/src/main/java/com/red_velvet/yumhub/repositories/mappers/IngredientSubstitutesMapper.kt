package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.IngredientSubstitutesEntity
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientSubstituteResource


fun IngredientSubstituteResource.toIngredientSubstitute(): IngredientSubstitutesEntity {
    return IngredientSubstitutesEntity(
        ingredient = ingredient.orEmpty(),
        substitutes = substitutes?.filterNotNull()
    )
}
