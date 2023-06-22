package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.repositories.RecipesRepositoryImpl
import javax.inject.Inject

class GetDietRecipeUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepositoryImpl
) {
    suspend operator fun invoke(
        type: String,
    ): List<SearchRecipeEntity> {
        return recipesRepositoryImpl
            .getDietRecipe(
                type = type,
            )
    }
}