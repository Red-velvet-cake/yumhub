package com.red_velvet.repository.datasources

import com.red_velvet.repository.entities.CategoryLocalDto
import com.red_velvet.repository.entities.HealthyRecipeLocalDto
import com.red_velvet.repository.entities.MealPlanLocalDto
import com.red_velvet.repository.entities.PopularRecipeLocalDto
import com.red_velvet.repository.entities.QuickRecipeLocalDto
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getCategories(): List<CategoryLocalDto>

    fun getWeekMealsPlan(fromTimestamp: Long, toTimestamp: Long): Flow<List<MealPlanLocalDto>>

    suspend fun insertWeekPlanMeal(mealPlanLocalDto: List<MealPlanLocalDto>)

    fun getHealthyRecipes(): Flow<List<HealthyRecipeLocalDto>>

    suspend fun insertHealthyRecipes(healthyRecipes: List<HealthyRecipeLocalDto>)

    fun getPopularRecipes(): Flow<List<PopularRecipeLocalDto>>

    suspend fun insertPopularRecipes(popularRecipes: List<PopularRecipeLocalDto>)

    fun getQuickRecipes(): Flow<List<QuickRecipeLocalDto>>

    suspend fun insertQuickRecipes(quickRecipes: List<QuickRecipeLocalDto>)

}