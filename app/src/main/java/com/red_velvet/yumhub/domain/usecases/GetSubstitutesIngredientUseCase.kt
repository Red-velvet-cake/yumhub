package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.repositories.IngredientRepository
import com.red_velvet.yumhub.domain.mapper.IngredientSubstitutesMapper
import com.red_velvet.yumhub.domain.models.IngredientSubstitutes
import javax.inject.Inject

class GetSubstitutesIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
    private  val  ingredientSubstitutesMapper:IngredientSubstitutesMapper,
) {
    suspend operator fun  invoke(ingredientName: String): IngredientSubstitutes {
        val response=ingredientRepository
            .getSubstitutesIngredient(
                ingredientName =ingredientName,
            )
        return  ingredientSubstitutesMapper.map(response)
    }
}