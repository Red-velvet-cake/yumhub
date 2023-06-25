package com.red_velvet.yumhub.domain.usecases.recipes

import com.red_velvet.yumhub.domain.models.recipes.NutritionWidgetEntity
import com.red_velvet.yumhub.repositories.RecipesRepositoryImpl
import javax.inject.Inject

class GetNutritionWidgetUseCase @Inject constructor(
    private val recipesRepository: RecipesRepositoryImpl
) {
    suspend operator fun invoke(id: Int): NutritionWidgetEntity {
        return recipesRepository.getNutritionWidget(id)
    }
}