package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.AddMealDto
import kotlinx.coroutines.flow.Flow



interface MealRepository {

    suspend fun addToMealPlan(
        addToMeal: AddMealDto,
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