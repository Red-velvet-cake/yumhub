package com.red_velvet.yumhub.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.yumhub.data.local.entities.RecipeEntity

@Dao
interface RecipeDao {
    @Query("SELECT * FROM RecipeEntity WHERE type = :type")
    suspend fun getRecipe(type: String):List<RecipeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipeEntity: List<RecipeEntity>)

}