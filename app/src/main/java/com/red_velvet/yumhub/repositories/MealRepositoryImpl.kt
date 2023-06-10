package com.red_velvet.yumhub.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import com.red_velvet.yumhub.domain.mapper.toEntity
import com.red_velvet.yumhub.domain.mapper.toMealPlan
import com.red_velvet.yumhub.domain.models.MealPlanEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MealRepository {

    override suspend fun addToMealPlan(
        addToMeal: com.red_velvet.yumhub.remote.dtos.meal_plan.AddMealDto,
        username: String,
        hash: String
    ) {
        val response = remoteDataSource.addToMealPlan(addToMeal, username, hash)
        if (!response.isSuccessful) {
            throw Exception(response.message())
        }
    }

    override fun getWeekMealsPlan(
        fromTimestamp: Long,
        toTimestamp: Long
    ): Flow<List<MealPlanEntity>> {
        return localDataSource.getWeekMealsPlan(fromTimestamp, toTimestamp).map { mealPlanEntities ->
            mealPlanEntities.map { it.toMealPlan() }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun refreshWeekMealsPlan(
        date: String,
        username: String,
        hash: String
    ) {
        val response = remoteDataSource.getWeekMealPlan(date, username, hash)
        response.body()?.days?.map { day ->
            day.items?.map {
                it.toEntity(Instant.now().toEpochMilli())
            }?.let { localDataSource.insertWeekPlanMeal(it) }
        }
    }

}
