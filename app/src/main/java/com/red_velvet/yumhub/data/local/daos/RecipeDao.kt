package com.red_velvet.yumhub.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.yumhub.data.local.entities.CategoryDatabaseDto
import com.red_velvet.yumhub.data.local.entities.HealthyRecipeDatabaseDto
import com.red_velvet.yumhub.data.local.entities.PopularRecipeDatabaseDto
import com.red_velvet.yumhub.data.local.entities.QuickRecipeDatabaseDto

@Dao
interface RecipeDao {
    @Query("SELECT * FROM HealthyRecipeDatabaseDto")
    suspend fun getHealthyRecipes(): List<HealthyRecipeDatabaseDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHealthyRecipes(healthyRecipes: List<HealthyRecipeDatabaseDto>)

    @Query("SELECT * FROM PopularRecipeDatabaseDto")
    suspend fun getPopularRecipes(): List<PopularRecipeDatabaseDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularRecipes(popularRecipes: List<PopularRecipeDatabaseDto>)

    @Query("SELECT * FROM QuickRecipeDatabaseDto ORDER BY cookingMinutes")
    suspend fun getQuickRecipes(): List<QuickRecipeDatabaseDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuickRecipes(quickRecipes: List<QuickRecipeDatabaseDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categoriesDatabase: List<CategoryDatabaseDto>)

    @Query("SELECT * FROM CATEGORIES_TABLE")
    suspend fun getCategories(): List<CategoryDatabaseDto>

}