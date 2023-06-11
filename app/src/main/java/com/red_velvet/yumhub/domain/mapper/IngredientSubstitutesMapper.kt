package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.domain.models.IngredientSubstitutesEntity


fun com.red_velvet.yumhub.remote.resources.ingredient.IngredientSubstituteDto.toIngredientSubstitute(): IngredientSubstitutesEntity {
    return IngredientSubstitutesEntity(
        ingredient = ingredient.orEmpty(),
        substitutes = substitutes?.filterNotNull()
    )
}
