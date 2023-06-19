package com.red_velvet.domain.usecases

import com.red_velvet.domain.repositories.IngredientRepository
import javax.inject.Inject

class GetSubstitutesIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
) {
    suspend operator fun invoke(ingredientName: String): com.red_velvet.domain.models.IngredientSubstitutesEntity {
        return ingredientRepository
            .getSubstitutesIngredient(
                ingredientName = ingredientName,
            )
    }
}