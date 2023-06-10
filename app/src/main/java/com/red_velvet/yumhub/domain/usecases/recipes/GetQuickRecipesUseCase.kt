package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.RecipesRepository
import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import javax.inject.Inject

class GetQuickRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(): List<QuickRecipeEntity> {
        return recipesRepositoryImpl.getQuickRecipesFromLocal().also { saveQuickRecipesLocal() }
    }

    private suspend fun getQuickRecipes(): List<QuickRecipeEntity> {
        return recipesRepositoryImpl.getQuickRecipes("time")
    }

    private suspend fun saveQuickRecipesLocal() {
        recipesRepositoryImpl.refreshQuickRecipes(getQuickRecipes())
    }

}