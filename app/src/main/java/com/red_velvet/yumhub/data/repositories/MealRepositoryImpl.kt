package com.red_velvet.yumhub.data.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import com.red_velvet.yumhub.data.local.daos.MealsDao
import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.AddMealDto
import com.red_velvet.yumhub.domain.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.Instant
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val foodServesImpl: FoodService,
    private val mealsDao: MealsDao
) : MealRepository {

    override suspend fun addToMealPlan(
        addToMeal: AddMealDto,
        username: String,
        hash: String
    ){
        val response = foodServesImpl.addToMealPlan(addToMeal, username, hash)
        if (!response.isSuccessful) {
            throw Exception(response.message())
        }


    }

    override fun getWeekMealsPlan(
        fromTimestamp: Long,
        toTimestamp: Long
    ): Flow<List<MealPlanEntity>> {
        return flow {
            emit(mealsDao.getWeekMealsPlan(fromTimestamp, toTimestamp))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun refreshWeekMealsPlan(
        date: String,
        username: String,
        hash: String
    ) {
        val response = foodServesImpl.getWeekMealPlan(date, username, hash)
        response.body()?.days?.map { day ->
            day.items?.map {
                it.toEntity(Instant.now().toEpochMilli())
            }?.let { mealsDao.insertWeekPlanMeal(it) }
        }
    }


}
