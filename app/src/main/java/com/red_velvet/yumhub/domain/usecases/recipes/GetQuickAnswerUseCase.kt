package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.data.repositories.RecipesRepository
import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswer
import javax.inject.Inject

class GetQuickAnswerUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {

    suspend fun getQuickAnswer(title: String): QuickAnswer {
        return recipesRepositoryImpl.getQuickAnswer(title).toModel()
    }
}