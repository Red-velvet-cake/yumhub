package com.red_velvet.yumhub.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.yumhub.local.entities.FavoriteRecipeDto
import com.red_velvet.yumhub.local.entities.HealthyRecipeLocalDto
import com.red_velvet.yumhub.local.entities.PopularRecipeLocalDto
import com.red_velvet.yumhub.local.entities.QuickAnswerLocalDto
import com.red_velvet.yumhub.local.entities.QuickRecipeLocalDto
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM HealthyRecipeLocalDto")
    fun getHealthyRecipes(): Flow<List<HealthyRecipeLocalDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHealthyRecipes(healthyRecipes: List<HealthyRecipeLocalDto>)

    @Query("SELECT * FROM PopularRecipeLocalDto")
    fun getPopularRecipes(): Flow<List<PopularRecipeLocalDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularRecipes(popularRecipes: List<PopularRecipeLocalDto>)

    @Query("SELECT * FROM QuickRecipeLocalDto ORDER BY cookingMinutes")
    fun getQuickRecipes(): Flow<List<QuickRecipeLocalDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuickRecipes(quickRecipes: List<QuickRecipeLocalDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavoriteRecipe(recipe: FavoriteRecipeDto)

    @Query("SELECT * FROM FAVORITE_RECIPES_TABLE")
    suspend fun getFavoriteRecipes(): List<FavoriteRecipeDto>

    @Delete
    suspend fun deleteFavoriteRecipe(recipe: FavoriteRecipeDto)

    @Query("DELETE  FROM FAVORITE_RECIPES_TABLE")
    suspend fun clearFavoriteRecipes()
}