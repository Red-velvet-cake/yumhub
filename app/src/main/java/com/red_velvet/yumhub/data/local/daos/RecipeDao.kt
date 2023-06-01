package com.red_velvet.yumhub.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.yumhub.data.local.entities.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM RecipeEntity WHERE type = :type")
    fun getRecipe(type: String):Flow<List<RecipeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipeEntity: List<RecipeEntity>)

}