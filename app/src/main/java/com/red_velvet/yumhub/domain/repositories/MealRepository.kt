package com.red_velvet.yumhub.domain.repositories

import com.red_velvet.yumhub.domain.models.DayPlannedMealsEntity
import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.models.MealPlanEntity


interface MealRepository {

    suspend fun addToMealPlan(
        addToMeal: MealPlanEntity,
        username: String,
        hash: String
    )

    suspend fun getWeeklyPlannedMeals(
        username: String,
        hash: String,
        date: String
    ): List<DayPlannedMealsEntity>

    suspend fun addToHistoryMeals(historyMealEntity: List<HistoryMealEntity>)

    suspend fun deleteFromHistoryMeals(mealId: Int)

    suspend fun getHistoryMeals(): Flow<List<HistoryMealEntity>>

}