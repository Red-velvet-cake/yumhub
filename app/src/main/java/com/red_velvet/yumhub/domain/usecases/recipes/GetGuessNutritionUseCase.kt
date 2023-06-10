package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.RecipesRepository
import com.red_velvet.yumhub.domain.models.recipes.GuessNutrition
import javax.inject.Inject

class GetGuessNutritionUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(title: String): GuessNutrition {
        return recipesRepositoryImpl.guessNutrition(title)
    }

}