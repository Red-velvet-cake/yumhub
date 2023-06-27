package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val recipesRepositoryImpl: RecipesRepository
) {
        suspend operator fun invoke(qsn: String) {
            return recipesRepositoryImpl.getQuickAnswer(qsn)
        }
}