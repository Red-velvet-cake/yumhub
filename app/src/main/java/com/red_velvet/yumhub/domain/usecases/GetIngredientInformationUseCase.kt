package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.ingredientInformation.IngredientInformationEntity
import com.red_velvet.yumhub.domain.repositories.IngredientRepository
import javax.inject.Inject

class GetIngredientInformationUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
) {
    suspend operator fun invoke(
        id: Int,
        amount: Int?,
        unit: String?
    ): IngredientInformationEntity {
        return ingredientRepository.getIngredientInformation(
            id = id,
            amount = amount,
            unit = unit,
        )
    }
}