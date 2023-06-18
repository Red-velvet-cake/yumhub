package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.MealPlanEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeekMealsPlanUseCase @Inject constructor(
    private val mealRepository: MealRepository,
) {
    operator fun invoke(
        fromTimestamp: Long,
        toTimesTamp: Long
    ): Flow<List<MealPlanEntity>> {
        return mealRepository
            .getWeekMealsPlan(fromTimestamp, toTimesTamp)
    }
}