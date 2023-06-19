package com.red_velvet.domain.usecases

import com.red_velvet.domain.repositories.IngredientRepository
import javax.inject.Inject

class GetIngredientInformationUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
) {
    suspend operator fun invoke(
        id: Int,
        amount: Int?,
        unit: String?
    ): com.red_velvet.domain.models.ingredientInformation.IngredientInformationEntity {
        return ingredientRepository.getIngredientInformation(
            id = id,
            amount = amount,
            unit = unit,
        )
    }
}