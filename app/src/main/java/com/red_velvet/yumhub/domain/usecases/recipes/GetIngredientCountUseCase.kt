package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructionsEntity
import javax.inject.Inject

class GetIngredientCountUseCase @Inject constructor() {
    operator fun invoke(ingredientNumber: List<AnalyzedInstructionsEntity>):Int {
        return ingredientNumber.flatMap { instruction -> instruction.steps }
            .sumOf { step ->
                step.ingredientsEntity?.size ?: 0
            }
    }
}