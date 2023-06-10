package com.red_velvet.yumhub.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.red_velvet.yumhub.data.local.daos.MealsDao
import com.red_velvet.yumhub.data.local.daos.RecipeDao
import com.red_velvet.yumhub.data.local.entities.CategoryDatabaseDto
import com.red_velvet.yumhub.data.local.entities.HealthyRecipeDatabaseDto
import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.data.local.entities.PopularRecipeDatabaseDto
import com.red_velvet.yumhub.data.local.entities.QuickRecipeDatabaseDto

@Database(
    entities = [
        MealPlanEntity::class,
        HealthyRecipeDatabaseDto::class,
        PopularRecipeDatabaseDto::class,
        QuickRecipeDatabaseDto::class,
        CategoryDatabaseDto::class],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun mealsDao(): MealsDao

    abstract fun recipeDao(): RecipeDao
}