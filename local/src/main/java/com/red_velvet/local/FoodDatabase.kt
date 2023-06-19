package com.red_velvet.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.red_velvet.local.daos.MealsDao
import com.red_velvet.local.daos.RecipeDao
import com.red_velvet.repository.entities.CategoryDatabaseDto
import com.red_velvet.repository.entities.HealthyRecipeLocalDto
import com.red_velvet.repository.entities.MealPlanLocalDto
import com.red_velvet.repository.entities.PopularRecipeLocalDto
import com.red_velvet.repository.entities.QuickRecipeLocalDto

@Database(
    entities = [
        MealPlanLocalDto::class,
        HealthyRecipeLocalDto::class,
        PopularRecipeLocalDto::class,
        QuickRecipeLocalDto::class,
        CategoryDatabaseDto::class],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun mealsDao(): MealsDao

    abstract fun recipeDao(): RecipeDao
}