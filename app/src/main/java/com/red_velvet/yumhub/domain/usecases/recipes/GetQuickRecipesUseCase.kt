package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuickRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(): Flow<List<QuickRecipeEntity>> {
        return recipesRepositoryImpl.getQuickRecipesFromLocal().also { saveQuickRecipesLocal() }
    }

    private suspend fun getQuickRecipes(): List<QuickRecipeEntity> {
        return recipesRepositoryImpl.getQuickRecipes("time")
    }

    private suspend fun saveQuickRecipesLocal() {
        recipesRepositoryImpl.refreshQuickRecipes(getQuickRecipes())
    }

}