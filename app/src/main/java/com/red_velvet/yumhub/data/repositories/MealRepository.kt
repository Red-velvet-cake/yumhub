package com.red_velvet.yumhub.data.repositories

import androidx.room.Insert
import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.AddMealDto
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.ResultAddToMealPlanDto
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.WeekMealPlanDto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MealRepository {

    suspend fun addToMealPlan(
        addToMeal: AddMealDto,
        username: String,
        hash: String
    ): ResultAddToMealPlanDto


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