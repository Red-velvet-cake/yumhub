package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class GuessNutritionUseCase @Inject constructor(
    private val RecipeRepositoryImpl: RecipesRepository
)
{
    suspend operator fun invoke(title: String): GuessNutritionEntity {
        return RecipeRepositoryImpl.guessNutrition(title=title)
    }
}