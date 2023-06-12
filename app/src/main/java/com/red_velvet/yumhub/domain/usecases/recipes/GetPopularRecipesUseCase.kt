package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class GetPopularRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(): Flow<List<PopularRecipeEntity>> {
        return recipesRepositoryImpl.getPopularRecipesFromLocal().onEmpty {
            savePopularRecipesLocal()
        }
    }

    private suspend fun getPopularRecipes(): List<PopularRecipeEntity> {
        return recipesRepositoryImpl.getPopularRecipes("popularity")
    }

    private suspend fun savePopularRecipesLocal() {
        recipesRepositoryImpl.refreshPopularRecipes(getPopularRecipes())
    }

}