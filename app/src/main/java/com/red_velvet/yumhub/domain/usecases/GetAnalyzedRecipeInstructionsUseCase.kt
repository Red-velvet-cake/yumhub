package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository

import javax.inject.Inject

class GetAnalyzedRecipeInstructionsUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) {
    suspend operator fun invoke(id: Int): List<AnalyzedInstructionsEntity> {
        return recipesRepository.getAnalyzedRecipeInstructions(id)
    }
}
