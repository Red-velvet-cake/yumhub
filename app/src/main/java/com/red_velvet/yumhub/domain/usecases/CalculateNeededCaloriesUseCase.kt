package com.red_velvet.yumhub.domain.usecases

import android.util.Log
import com.red_velvet.yumhub.domain.models.FoodSystemEntity
import com.red_velvet.yumhub.domain.models.recipes.RangeNeededCaloriesEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class CalculateNeededCaloriesUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository,
    private val calculateRangeOfNeededCaloriesUseCase: CalculateRangeOfNeededCaloriesUseCase
) {
    suspend fun calculateNeededCalories(rangeNeededCaloriesEntity: RangeNeededCaloriesEntity): List<RecipeEntity> {
        return recipesRepository.getMealByCalories(
            minCalories = rangeNeededCaloriesEntity.minimumCalories,
            maxCalories = rangeNeededCaloriesEntity.maximumCalories
        )
    }
}