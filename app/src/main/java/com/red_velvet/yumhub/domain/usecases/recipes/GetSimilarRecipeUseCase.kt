package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.data.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.SimilarRecipe
import javax.inject.Inject

class GetSimilarRecipeUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend fun getSimilarRecipes(
        id: Int, number: Int?
    ): List<SimilarRecipe> {
        return recipesRepositoryImpl.getSimilarRecipes(id, number).map {
            it.toModel()
        }
    }

}