package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.RecipesRepository
import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import javax.inject.Inject

class GetHealthyRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(): List<HealthyRecipeEntity> {
        return recipesRepositoryImpl.getHealthyRecipes("healthiness")
            .also { saveHealthyRecipesLocal() }
    }

    private suspend fun getHealthyRecipes(): List<HealthyRecipeEntity> {
        return recipesRepositoryImpl.getHealthyRecipes("healthiness")
    }

    private suspend fun saveHealthyRecipesLocal() {
        recipesRepositoryImpl.refreshHealthyRecipes(getHealthyRecipes())
    }

}