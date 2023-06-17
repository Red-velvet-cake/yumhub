package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.IngredientSearchEntity
import com.red_velvet.yumhub.domain.repositories.IngredientRepository
import javax.inject.Inject

class SearchIngredientUseCase @Inject constructor(
    private val ingredientRepository: IngredientRepository,
) {
    suspend operator fun invoke(
        query: String,
        intolerances: String?,
        sort: String?,
        number: Int
    ): List<IngredientSearchEntity> {
        return ingredientRepository.searchIngredient(
            query = query,
            sort = sort,
            intolerances = intolerances,
            number = number
        )
    }
}