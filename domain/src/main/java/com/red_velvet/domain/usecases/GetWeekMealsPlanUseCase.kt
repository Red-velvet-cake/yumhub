package com.red_velvet.domain.usecases

import com.red_velvet.domain.repositories.MealRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeekMealsPlanUseCase @Inject constructor(
    private val mealRepository: MealRepository,
) {
    operator fun invoke(
        fromTimestamp: Long,
        toTimesTamp: Long
    ): Flow<List<com.red_velvet.domain.models.MealPlanEntity>> {
        return mealRepository
            .getWeekMealsPlan(fromTimestamp, toTimesTamp)
    }
}