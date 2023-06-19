package com.red_velvet.domain.usecases.recipes

import com.red_velvet.domain.repositories.RecipesRepository
import com.red_velvet.domain.usecases.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase
) {

    suspend operator fun invoke(): Flow<List<com.red_velvet.domain.models.recipes.PopularRecipeEntity>> {
        if (shouldCacheApiResponseUseCase("popular_recipes")) {
            refreshLocalPopularRecipes()
        }
        return recipesRepositoryImpl.getPopularRecipesFromLocal()
    }

    private suspend fun getPopularRecipes(): List<com.red_velvet.domain.models.recipes.PopularRecipeEntity> {
        return recipesRepositoryImpl.getPopularRecipes("popularity")
    }

    private suspend fun refreshLocalPopularRecipes() {
        val popularRecipes = getPopularRecipes()
        recipesRepositoryImpl.refreshPopularRecipes(popularRecipes)
    }

}