package com.red_velvet.domain.usecases.recipes

import com.red_velvet.domain.models.recipes.RecipeInformationEntity
import com.red_velvet.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetRandomRecipeUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(tags: String?, number: Int?): List<RecipeInformationEntity> {
        return recipesRepositoryImpl.getRandomRecipes(tags, number)
    }

}