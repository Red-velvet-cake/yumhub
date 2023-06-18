package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetQuickAnswerUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(title: String): QuickAnswerEntity {
        return recipesRepositoryImpl.getQuickAnswer(title)
    }
}