package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.RecipesRepository
import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import javax.inject.Inject

class GetPopularRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(): List<PopularRecipeEntity> {
        return recipesRepositoryImpl.getPopularRecipesFromLocal().also { savePopularRecipesLocal() }
    }

    private suspend fun getPopularRecipes(): List<PopularRecipeEntity> {
        return recipesRepositoryImpl.getPopularRecipes("popularity")
    }

    private suspend fun savePopularRecipesLocal() {
        recipesRepositoryImpl.refreshPopularRecipes(getPopularRecipes())
    }

}