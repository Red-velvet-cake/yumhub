package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.data.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    fun getRecipes(recipeType: String): Flow<List<Recipe>> {
        return recipesRepositoryImpl.getRecipes(recipeType).map { recipeEntities ->
            recipeEntities.map {
                it.toModel()
            }
        }
    }
}