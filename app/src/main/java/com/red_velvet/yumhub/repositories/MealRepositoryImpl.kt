package com.red_velvet.yumhub.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import com.red_velvet.yumhub.domain.mapper.toEntity
import com.red_velvet.yumhub.domain.mapper.toHistoryItemLocalDto
import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.models.MealPlanEntity
import com.red_velvet.yumhub.domain.models.toHistoryItemLocalEntity
import com.red_velvet.yumhub.domain.models.toMealPlanResource
import com.red_velvet.yumhub.domain.repositories.MealRepository
import com.red_velvet.yumhub.repositories.datasources.LocalDataSource
import com.red_velvet.yumhub.repositories.datasources.RemoteDataSource
import com.red_velvet.yumhub.repositories.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource
) : MealRepository {

    override suspend fun addToMealPlan(
        addToMeal: MealPlanEntity, username: String, hash: String
    ) {
        val mealPlanObj = addToMeal.toMealPlanResource()
        remoteDataSource.addToMealPlan(mealPlanObj, username, hash)
    }

    override fun getWeekMealsPlan(
        fromTimestamp: Long, toTimestamp: Long
    ): Flow<List<MealPlanEntity>> {
        return localDataSource.getWeekMealsPlan(fromTimestamp, toTimestamp)
            .map { mealPlanEntities ->
                mealPlanEntities.map { it.toEntity() }
            }
    }

    override suspend fun addToHistoryMeals(historyMealEntity: HistoryMealEntity) {
        localDataSource.insertHistoryItem(historyMealEntity.toHistoryItemLocalDto())
    }

    override fun getHistoryMeals(): Flow<List<HistoryMealEntity>> {
        return localDataSource.getHistoryMeals().map { historyMealEntities ->
            historyMealEntities.map { it.toHistoryItemLocalEntity() }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun refreshWeekMealsPlan(
        date: String, username: String, hash: String
    ) {

        localDataSource.insertWeekPlanMeal(
            remoteDataSource.getWeekMealPlan(
                date, username, hash
            ).dayResources?.let {
                it.mapNotNull { day ->
                    day.itemResources?.map { item ->
                        item.toEntity(Instant.now().toEpochMilli())
                    }
                }
            }?.flatten()!!
        )

//        val l = remoteDataSource.getWeekMealPlan(
//            date,
//            username,
//            hash
//        ).dayResources?.let {
//            it.map {
//                it.itemResources?.map {
//                    it.toEntity(Instant.now().toEpochMilli())
//                }
//            }
//        }

    }
//            .map { day ->
//            day.items?.map {
//                it.toEntity(Instant.now().toEpochMilli())
//            }?.let { localDataSource.insertWeekPlanMeal(it) }
//        }


}


