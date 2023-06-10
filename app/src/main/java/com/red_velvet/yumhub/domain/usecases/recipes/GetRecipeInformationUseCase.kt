package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformationEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetRecipeInformationUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(
        id: Int,
        includeNutrition: Boolean?
    ): RecipeInformationEntity {
        return recipesRepositoryImpl.getRecipeInformation(id, includeNutrition).toModel()
    }
}