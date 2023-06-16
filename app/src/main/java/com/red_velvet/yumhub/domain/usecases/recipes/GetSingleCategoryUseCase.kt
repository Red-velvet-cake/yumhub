package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetSingleCategoryUseCase @Inject constructor(
    private val repository: RecipesRepository
) {

    suspend operator fun invoke(): List<RecipeEntity> {
        return repository.getSingleRecipeCategory("main course")
    }
}