package com.red_velvet.yumhub.domain.repositories

import com.red_velvet.yumhub.domain.models.UserInformationEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity

interface UserRepository {

    suspend fun saveUserName(userData: UserInformationEntity)

    suspend fun getUserName(): String

    suspend fun getHash(): String

    suspend fun saveCachingTimeStamp(key: String, cachingTime: Long)

    suspend fun getLastCachingTimeStamp(key: String): Long

    suspend fun getFavoriteRecipes(): List<RecipeEntity>

    suspend fun saveFavoriteRecipe(recipe: RecipeEntity)

    suspend fun deleteFavoriteRecipe(recipe: RecipeEntity)

    suspend fun clearFavoriteRecipes()


}