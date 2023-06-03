package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSubstituteDto
import com.red_velvet.yumhub.domain.models.IngredientSubstitutes


    fun IngredientSubstituteDto.toIngredientSubstitute(): IngredientSubstitutes {
        return IngredientSubstitutes(
            ingredient  = ingredient ?: "",
            substitutes = substitutes?.filterNotNull() ?: emptyList(),
        )
    }
