package com.red_velvet.domain.repositories

import com.red_velvet.domain.models.MealPlanEntity
import kotlinx.coroutines.flow.Flow


interface MealRepository {

    suspend fun addToMealPlan(
        addToMeal: MealPlanEntity,
        username: String,
        hash: String
    )

    fun getWeekMealsPlan(
        fromTimestamp: Long,
        toTimestamp: Long
    ): Flow<List<MealPlanEntity>>

    suspend fun refreshWeekMealsPlan(
        date: String,
        username: String,
        hash: String
    )
}