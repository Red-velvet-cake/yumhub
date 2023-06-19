package com.red_velvet.repository

import com.red_velvet.domain.models.MealPlanEntity
import com.red_velvet.domain.repositories.MealRepository
import com.red_velvet.repository.datasources.LocalDataSource
import com.red_velvet.repository.datasources.RemoteDataSource
import com.red_velvet.repository.mappers.toEntity
import com.red_velvet.repository.mappers.toMealPlanEntity
import com.red_velvet.repository.mappers.toMealPlanResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :MealRepository {

    override suspend fun addToMealPlan(
        addToMeal: MealPlanEntity,
        username: String,
        hash: String
    ) {
        remoteDataSource.addToMealPlan(addToMeal.toMealPlanResource(), username, hash)
    }




    override fun getWeekMealsPlan(
        fromTimestamp: Long,
        toTimestamp: Long
    ): Flow<List<MealPlanEntity>> {
        return localDataSource.getWeekMealsPlan(fromTimestamp, toTimestamp)
            .map { mealPlanEntities ->
                mealPlanEntities.map { it.toMealPlanEntity() }
            }
    }


    override suspend fun refreshWeekMealsPlan(
        date: String,
        username: String,
        hash: String
    ) {

        localDataSource.insertWeekPlanMeal(
            remoteDataSource.getWeekMealPlan(
                date,
                username,
                hash
            ).dayResources?.let {
                it.mapNotNull { day ->
                    day.itemResources?.map { item ->
                        item.toEntity(Date().time)
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


