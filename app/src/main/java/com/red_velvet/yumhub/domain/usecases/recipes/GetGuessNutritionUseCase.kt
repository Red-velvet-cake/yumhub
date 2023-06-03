package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.data.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.GuessNutrition
import javax.inject.Inject

class GetGuessNutritionUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend fun guessNutrition(title: String): GuessNutrition {
        return recipesRepositoryImpl.guessNutrition(title).toModel()
    }

}