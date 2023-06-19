package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.IngredientSubstitutesEntity
import com.red_velvet.repository.resources.ingredient.IngredientSubstituteResource


internal fun IngredientSubstituteResource.toIngredientSubstitute(): IngredientSubstitutesEntity {
    return IngredientSubstitutesEntity(
        ingredient = ingredient.orEmpty(),
        substitutes = substitutes?.filterNotNull()
    )
}
