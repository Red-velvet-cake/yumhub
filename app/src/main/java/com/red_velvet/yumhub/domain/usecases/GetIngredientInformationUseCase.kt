package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.repositories.IngredientRepository
import javax.inject.Inject

class GetIngredientInformationUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository
) {
    suspend operator fun  invoke(
        id: Int,
        amount :Int?,
        unit: String?
    ): IngredientSearchDto {
        return ingredientRepository
            .getIngredientInformation(
                id =id,
                amount =amount,
                unit = unit,
               ).toModel()

    }
}