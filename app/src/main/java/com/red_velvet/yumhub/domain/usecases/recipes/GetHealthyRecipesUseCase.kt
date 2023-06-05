package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.data.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.models.recipes.Recipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHealthyRecipesUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    operator fun invoke(): Flow<List<Recipe>> {
        return recipesRepositoryImpl.getRecipes("healthiness")
    }

}