package com.red_velvet.domain.usecases

import com.red_velvet.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetAnalyzedRecipeInstructionsUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) {
    suspend operator fun invoke(id: Int): List<com.red_velvet.domain.models.recipes.AnalyzedInstructionsEntity> {
        return recipesRepository.getAnalyzedRecipeInstructions(id)
    }
}
