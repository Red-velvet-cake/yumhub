package com.red_velvet.yumhub.repositories

import com.red_velvet.yumhub.local.entities.CategoryLocalDto
import com.red_velvet.yumhub.local.entities.HealthyRecipeLocalDto
import com.red_velvet.yumhub.local.entities.MealPlanLocalDto
import com.red_velvet.yumhub.local.entities.PopularRecipeLocalDto
import com.red_velvet.yumhub.local.entities.QuickRecipeLocalDto
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