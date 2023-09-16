package com.red_velvet.yumhub.repositories

import com.red_velvet.yumhub.domain.mapper.toHistoryItemLocalDto
import com.red_velvet.yumhub.domain.models.DayPlannedMealsEntity
import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.models.MealPlanEntity
import com.red_velvet.yumhub.domain.models.toHistoryItemLocalEntity
import com.red_velvet.yumhub.domain.models.toMealPlanResource
import com.red_velvet.yumhub.domain.repositories.MealRepository
import com.red_velvet.yumhub.repositories.datasources.LocalDataSource
import com.red_velvet.yumhub.repositories.datasources.RemoteDataSource
import com.red_velvet.yumhub.repositories.mappers.toDayPlannedMealEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MealRepository {

    override suspend fun addToMealPlan(
        addToMeal: MealPlanEntity,
        username: String,
        hash: String
    ) {
        val mealPlanObj = addToMeal.toMealPlanResource()
        remoteDataSource.addToMealPlan(mealPlanObj, username, hash)
    }

    override suspend fun getWeeklyPlannedMeals(
        username: String,
        hash: String,
        date: String
    ): List<DayPlannedMealsEntity> {
        return remoteDataSource.getWeekMealPlan(date, username, hash).toDayPlannedMealEntity()
    }

    override suspend fun addToHistoryMeals(historyMealEntity: List<HistoryMealEntity>) {
        localDataSource.insertHistoryItem(historyMealEntity.map(HistoryMealEntity::toHistoryItemLocalDto))
    }

    override suspend fun deleteFromHistoryMeals(mealId: Int) {
        localDataSource.deleteHistoryItem(mealId)
    }

    override suspend fun getHistoryMeals(): Flow<List<HistoryMealEntity>> {
        return localDataSource.getHistoryMeals().map {
            it.map { historyItemLocalDto ->
                historyItemLocalDto.toHistoryItemLocalEntity()
            }
        }
    }

}


