package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetGuessNutritionUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(title: String): GuessNutritionEntity {
        return recipesRepositoryImpl.guessNutrition(title)
    }

}