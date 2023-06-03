package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.repositories.IngredientRepository
import com.red_velvet.yumhub.domain.mapper.toIngredientSubstitute
import com.red_velvet.yumhub.domain.models.IngredientSubstitutes
import javax.inject.Inject

class GetSubstitutesIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
) {
    suspend operator fun invoke(ingredientName: String): IngredientSubstitutes {
        return ingredientRepository
            .getSubstitutesIngredient(
                ingredientName = ingredientName,
            ).toIngredientSubstitute()
    }
}