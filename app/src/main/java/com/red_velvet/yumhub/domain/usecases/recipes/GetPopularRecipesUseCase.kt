package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.usecases.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPopularRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase
) {

    suspend operator fun invoke(): Flow<List<PopularRecipeEntity>> {
        if (shouldCacheApiResponseUseCase("popular_recipes")) {
            refreshLocalPopularRecipes()
        }
        return recipesRepositoryImpl.getPopularRecipesFromLocal().map { it.shuffled() }
    }

    private suspend fun getPopularRecipes(): List<PopularRecipeEntity> {
        return recipesRepositoryImpl.getPopularRecipes("popularity")
    }

    private suspend fun refreshLocalPopularRecipes() {
        val popularRecipes = getPopularRecipes()
        recipesRepositoryImpl.refreshPopularRecipes(popularRecipes)
    }

}