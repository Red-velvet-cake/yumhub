package com.red_velvet.domain.usecases

import com.red_velvet.domain.repositories.IngredientRepository
import javax.inject.Inject

class SearchIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
) {
    suspend operator fun invoke(
        query: String,
        intolerances: String?,
        sort: String?,
        number: Int
    ): List<com.red_velvet.domain.models.IngredientSearchEntity> {
        return ingredientRepository.searchIngredient(
            query = query,
            sort = sort,
            intolerances = intolerances,
            number = number
        )
    }
}