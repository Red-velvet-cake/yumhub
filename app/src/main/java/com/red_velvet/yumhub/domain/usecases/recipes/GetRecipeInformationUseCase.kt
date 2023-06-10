package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.RecipesRepository
import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import javax.inject.Inject

class GetRecipeInformationUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(
        id: Int,
        includeNutrition: Boolean?
    ): RecipeInformation {
        return recipesRepositoryImpl.getRecipeInformation(id, includeNutrition).toModel()
    }
}