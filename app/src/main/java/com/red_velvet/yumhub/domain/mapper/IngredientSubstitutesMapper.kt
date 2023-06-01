package com.red_velvet.yumhub.domain.mapper

import com.karrar.movieapp.domain.mappers.Mapper
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSubstituteDto
import com.red_velvet.yumhub.domain.models.IngredientSearch
import com.red_velvet.yumhub.domain.models.IngredientSubstitutes
import javax.inject.Inject

class IngredientSubstitutesMapper  @Inject constructor() :
    Mapper<IngredientSubstituteDto, IngredientSubstitutes> {
    override fun map(input: IngredientSubstituteDto): IngredientSubstitutes {
        return IngredientSubstitutes(
            ingredient  = input.ingredient ?: "",
            substitutes = input.substitutes ?: emptyList(),

        )
    }
}