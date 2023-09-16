package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import javax.inject.Inject

class RemoveHistoryRecipeUseCase @Inject constructor(
    private val mealRepository: MealRepository
) {
    suspend operator fun invoke(recipe: RecipeEntity) {
        mealRepository.deleteFromHistoryMeals(recipe.id)
    }
}