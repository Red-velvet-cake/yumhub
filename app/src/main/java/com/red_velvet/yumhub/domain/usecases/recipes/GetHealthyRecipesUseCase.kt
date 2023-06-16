package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.usecases.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHealthyRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase
) {

    suspend operator fun invoke(): Flow<List<HealthyRecipeEntity>> {
        if (shouldCacheApiResponseUseCase("healthy_recipes")) {
            refreshLocalHealthyRecipes()
        }
        return recipesRepositoryImpl.getHealthyRecipesFromLocal()
    }

    private suspend fun getHealthyRecipes(): List<HealthyRecipeEntity> {
        return recipesRepositoryImpl.getHealthyRecipesFromRemote("healthiness")
    }

    private suspend fun refreshLocalHealthyRecipes() {
        val healthyRecipes = getHealthyRecipes()
        recipesRepositoryImpl.refreshHealthyRecipes(healthyRecipes)
    }

}