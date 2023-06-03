package com.red_velvet.yumhub.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.red_velvet.yumhub.data.local.daos.MealsDao
import com.red_velvet.yumhub.data.local.daos.RecipeDao
import com.red_velvet.yumhub.data.local.entities.MealPlanEntity
import com.red_velvet.yumhub.data.local.entities.RecipeEntity

@Database(
    entities = [
        MealPlanEntity::class,
        RecipeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun mealsDao(): MealsDao

    abstract fun recipeDao(): RecipeDao
}