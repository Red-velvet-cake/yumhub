package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.repositories.IngredientRepository
import javax.inject.Inject

class GetSubstitutesIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository
) {
    suspend operator fun  invoke(ingredientName: String): IngredientSearchDto {
        val response=ingredientRepository
            .getSubstitutesIngredient(
                ingredientName =ingredientName,
            )
        return response?.let {
            movieDetailsMapper.map(response)
        } ?: throw Throwable()
    }
}