package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.data.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import javax.inject.Inject

class GetRandomRecipeUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(tags: String?, number: Int?): List<RecipeInformation> {
        return recipesRepositoryImpl.getRandomRecipes(tags, number).recipes!!.map {
            it.toModel()
        }
    }

}