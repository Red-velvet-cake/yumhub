package com.red_velvet.domain.usecases.recipes

import com.red_velvet.domain.models.recipes.RecipeInformationEntity
import com.red_velvet.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetRecipeInformationUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(
        id: Int,
        includeNutrition: Boolean?
    ):RecipeInformationEntity {
        return recipesRepositoryImpl.getRecipeInformation(id, includeNutrition)
    }
}