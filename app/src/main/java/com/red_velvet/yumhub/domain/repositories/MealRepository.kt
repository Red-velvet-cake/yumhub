package com.red_velvet.yumhub.domain.repositories

import com.red_velvet.yumhub.domain.models.MealPlanEntity
import kotlinx.coroutines.flow.Flow


interface MealRepository {

    suspend fun addToMealPlan(
        addToMeal: com.red_velvet.yumhub.remote.resources.meal_plan.AddMealResource,
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