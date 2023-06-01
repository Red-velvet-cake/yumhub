package com.red_velvet.yumhub.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.yumhub.data.local.entities.MealPlanEntity


@Dao
interface MealsDao {

    @Query(
        """
        SELECT * FROM MealPlanEntity 
        WHERE timestamp BETWEEN :fromTimestamp AND :toTimestamp
    """
    )
    suspend fun getWeekMealsPlan(fromTimestamp: Long, toTimestamp: Long): List<MealPlanEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeekPlanMeal(mealPlanEntity: List<MealPlanEntity>)

}