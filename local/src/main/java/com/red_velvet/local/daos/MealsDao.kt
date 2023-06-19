package com.red_velvet.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.repository.entities.MealPlanLocalDto
import kotlinx.coroutines.flow.Flow


@Dao
interface MealsDao {

    @Query(
        """
        SELECT * FROM MealPlanLocalDto 
        WHERE timestamp BETWEEN :fromTimestamp AND :toTimestamp
    """
    )
    fun getWeekMealsPlan(fromTimestamp: Long, toTimestamp: Long): Flow<List<MealPlanLocalDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeekPlanMeal(mealPlanLocalDto: List<MealPlanLocalDto>)

}