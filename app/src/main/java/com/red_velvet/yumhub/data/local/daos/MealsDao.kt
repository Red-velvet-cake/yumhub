package com.red_velvet.yumhub.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MealsDao {

    @Query(
        """
        SELECT * FROM MealPlanEntity 
        WHERE timestamp BETWEEN :fromTimestamp AND :toTimestamp
    """
    )
    fun getWeekMealsPlan(fromTimestamp: Long, toTimestamp: Long): Flow<List<MealPlanEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeekPlanMeal(mealPlanEntity: List<MealPlanEntity>)

}