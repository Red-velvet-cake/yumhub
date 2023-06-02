package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.repositories.IngredientRepository
import com.red_velvet.yumhub.domain.mapper.toIngredientInformationDtoMapper
import com.red_velvet.yumhub.domain.models.ingredientInformation.IngredientInformation
import javax.inject.Inject

class GetIngredientInformationUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
) {
    suspend operator fun  invoke(
        id: Int,
        amount :Int?,
        unit: String?
    ): IngredientInformation {
        return ingredientRepository.getIngredientInformation(
                id =id,
                amount =amount,
                unit = unit,
            ).toIngredientInformationDtoMapper()
    }
}