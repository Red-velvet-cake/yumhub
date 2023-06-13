package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.RecipesRepository
import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructionsEntity

import javax.inject.Inject

class GetAnalyzedRecipeInstructionsUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) {
    suspend operator fun invoke(id: Int,stepBreakdown: Boolean? = false,): List<AnalyzedInstructionsEntity> {
        return recipesRepository.getAnalyzedRecipeInstructions(id)
    }
}
