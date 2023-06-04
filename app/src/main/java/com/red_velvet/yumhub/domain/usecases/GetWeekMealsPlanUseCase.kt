package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.repositories.MealRepository
import com.red_velvet.yumhub.domain.models.MealPlan
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeekMealsPlanUseCase @Inject constructor(
    private val mealRepository: MealRepository,
) {
    operator fun invoke(
        fromTimestamp: Long,
        toTimesTamp: Long
    ): Flow<List<MealPlan>> {
        return mealRepository
            .getWeekMealsPlan(fromTimestamp, toTimesTamp)
    }
}