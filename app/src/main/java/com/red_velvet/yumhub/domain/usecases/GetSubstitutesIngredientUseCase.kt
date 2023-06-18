package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.IngredientSubstitutesEntity
import com.red_velvet.yumhub.domain.repositories.IngredientRepository
import javax.inject.Inject

class GetSubstitutesIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
) {
    suspend operator fun invoke(ingredientName: String): IngredientSubstitutesEntity {
        return ingredientRepository
            .getSubstitutesIngredient(
                ingredientName = ingredientName,
            )
    }
}