package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(): Flow<List<PopularRecipeEntity>> {

        val list = recipesRepositoryImpl.getPopularRecipes("popularity")

        recipesRepositoryImpl.refreshPopularRecipes(list)

        return recipesRepositoryImpl.getPopularRecipesFromLocal()


//        savePopularRecipesLocal()
//        return recipesRepositoryImpl.getPopularRecipesFromLocal()
    }

    private suspend fun getPopularRecipes(): List<PopularRecipeEntity> {
        return recipesRepositoryImpl.getPopularRecipes("popularity")
    }

    private suspend fun savePopularRecipesLocal() {
        recipesRepositoryImpl.refreshPopularRecipes(getPopularRecipes())
    }

}