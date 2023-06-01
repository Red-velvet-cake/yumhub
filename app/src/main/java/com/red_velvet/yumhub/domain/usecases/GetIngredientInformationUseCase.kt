package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.repositories.IngredientRepository
import com.red_velvet.yumhub.domain.mapper.IngredientInformationMapper
import com.red_velvet.yumhub.domain.models.IngredientInformation
import javax.inject.Inject

class GetIngredientInformationUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
    private  val  ingredientInformationMapper: IngredientInformationMapper

) {
    suspend operator fun  invoke(
        id: Int,
        amount :Int?,
        unit: String?
    ): IngredientInformation {
        val response=ingredientRepository.getIngredientInformation(
                id =id,
                amount =amount,
                unit = unit,
            )
        return ingredientInformationMapper.map(response)

    }
}