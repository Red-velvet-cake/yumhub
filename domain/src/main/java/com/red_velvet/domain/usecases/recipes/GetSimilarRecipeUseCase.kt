package com.red_velvet.domain.usecases.recipes

import com.red_velvet.domain.models.recipes.SimilarRecipeEntity
import com.red_velvet.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetSimilarRecipeUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(
        id: Int, number: Int?
    ): List<SimilarRecipeEntity> {
        return recipesRepositoryImpl.getSimilarRecipes(id, number)
    }

}