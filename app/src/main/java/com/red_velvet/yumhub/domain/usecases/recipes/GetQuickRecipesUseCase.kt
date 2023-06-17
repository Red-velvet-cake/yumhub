package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.usecases.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class GetQuickRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase
) {

    suspend operator fun invoke(): Flow<List<QuickRecipeEntity>> {
        if (shouldCacheApiResponseUseCase("quick_recipes")) refreshLocalQuickRecipes()
        return recipesRepositoryImpl.getQuickRecipesFromLocal().onEmpty {
            refreshLocalQuickRecipes()
        }
    }

    private suspend fun getQuickRecipes(): List<QuickRecipeEntity> {
        return recipesRepositoryImpl.getQuickRecipes("time")
    }

    private suspend fun refreshLocalQuickRecipes() {
        val quickRecipes = getQuickRecipes()
        recipesRepositoryImpl.refreshQuickRecipes(quickRecipes)
    }

}