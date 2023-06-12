package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class GetHealthyRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(): Flow<List<HealthyRecipeEntity>> {
        return recipesRepositoryImpl.getHealthyRecipesFromLocal().onEmpty {
            saveHealthyRecipesLocal()
        }
    }

    private suspend fun getHealthyRecipes(): List<HealthyRecipeEntity> {
        return recipesRepositoryImpl.getHealthyRecipesFromRemote("healthiness")
    }

    private suspend fun saveHealthyRecipesLocal() {
        recipesRepositoryImpl.refreshHealthyRecipes(getHealthyRecipes())
    }

}