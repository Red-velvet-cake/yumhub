package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHistoryMealsUseCase @Inject constructor(
    private val mealRepository: MealRepository,
) {
    suspend operator fun invoke(): Flow<List<HistoryMealEntity>> {
        return mealRepository.getHistoryMeals()
    }
}
