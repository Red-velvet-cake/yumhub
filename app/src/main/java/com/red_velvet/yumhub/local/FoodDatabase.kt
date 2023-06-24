package com.red_velvet.yumhub.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.red_velvet.yumhub.local.daos.MealsDao
import com.red_velvet.yumhub.local.daos.RecipeDao
import com.red_velvet.yumhub.local.entities.CategoryDatabaseDto
import com.red_velvet.yumhub.local.entities.HealthyRecipeLocalDto
import com.red_velvet.yumhub.local.entities.HistoryItemLocalDto
import com.red_velvet.yumhub.local.entities.MealPlanLocalDto
import com.red_velvet.yumhub.local.entities.PopularRecipeLocalDto
import com.red_velvet.yumhub.local.entities.QuickRecipeLocalDto

@Database(
    entities = [
        MealPlanLocalDto::class,
        HealthyRecipeLocalDto::class,
        PopularRecipeLocalDto::class,
        HistoryItemLocalDto::class,
        QuickRecipeLocalDto::class,
        CategoryDatabaseDto::class],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun mealsDao(): MealsDao

    abstract fun recipeDao(): RecipeDao
}