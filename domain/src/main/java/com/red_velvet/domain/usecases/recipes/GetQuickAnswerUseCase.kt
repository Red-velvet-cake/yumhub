package com.red_velvet.domain.usecases.recipes

import com.red_velvet.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.domain.repositories.RecipesRepository
import javax.inject.Inject

class GetQuickAnswerUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend operator fun invoke(title: String): QuickAnswerEntity {
        return recipesRepositoryImpl.getQuickAnswer(title)
    }
}