package com.red_velvet.yumhub.domain.repositories

import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.models.MealPlanEntity
import kotlinx.coroutines.flow.Flow


interface MealRepository {

    suspend fun addToMealPlan(
        addToMeal: MealPlanEntity, username: String, hash: String
    )

    fun getWeekMealsPlan(
        fromTimestamp: Long, toTimestamp: Long
    ): Flow<List<MealPlanEntity>>

    suspend fun addToHistoryMeals(historyMealEntity: List<HistoryMealEntity>)

    fun getHistoryMeals(): List<HistoryMealEntity>


    suspend fun refreshWeekMealsPlan(
        date: String, username: String, hash: String
    )
}