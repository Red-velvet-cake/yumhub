package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.remote.dtos.meal_plan.AddMealDto
import com.red_velvet.yumhub.domain.models.MealPlan
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
    ): Flow<List<MealPlan>>

    suspend fun refreshWeekMealsPlan(
        date: String,
        username: String,
        hash: String
    )
}