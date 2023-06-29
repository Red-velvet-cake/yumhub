package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.recipes.ExtendedIngredientEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetIngredientsUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(id: Int, includeNutrition: Boolean)
            : List<ExtendedIngredientEntity> {
        return recipesRepositoryImpl.getExtendedIngredients(id, includeNutrition)
    }
}