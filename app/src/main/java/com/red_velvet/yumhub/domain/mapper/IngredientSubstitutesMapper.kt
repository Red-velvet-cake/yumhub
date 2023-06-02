package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSubstituteDto
import com.red_velvet.yumhub.domain.models.IngredientSubstitutes


    fun IngredientSubstituteDto.toIngredientSubstituteDtoMapper(): IngredientSubstitutes {
        return IngredientSubstitutes(
            ingredient  = this.ingredient ?: "",
            substitutes = this.substitutes?.filterNotNull() ?: emptyList(),
        )
    }
