package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.repositories.MealRepositoryImpl
import com.red_velvet.yumhub.domain.mapper.toMealPlanMapper
import com.red_velvet.yumhub.domain.models.MealPlan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetWeekMealsPlanUseCase @Inject constructor(
    private val repository: MealRepositoryImpl
) {

    operator fun invoke(
        fromTimestamp: Long,
        toTimestamp: Long
    ): Flow<List<MealPlan>> {
        return repository.getWeekMealsPlan(fromTimestamp, toTimestamp).map {
            it.map { entity ->
                entity.toMealPlanMapper()
            }

        }
    }
}