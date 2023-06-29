package com.red_velvet.yumhub.domain.repositories

import com.red_velvet.yumhub.domain.models.DayPlannedMealsEntity
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

}