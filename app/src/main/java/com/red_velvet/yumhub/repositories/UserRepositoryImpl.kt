package com.red_velvet.yumhub.repositories

import com.red_velvet.yumhub.domain.models.UserInformationEntity
import com.red_velvet.yumhub.domain.models.exceptions.NetworkException
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.repositories.UserRepository
import com.red_velvet.yumhub.remote.resources.auth.UserInformationResource
import com.red_velvet.yumhub.repositories.datasources.LocalDataSource
import com.red_velvet.yumhub.repositories.datasources.RemoteDataSource
import com.red_velvet.yumhub.repositories.datasources.SharedPreferenceService
import com.red_velvet.yumhub.repositories.mappers.toEntityList
import com.red_velvet.yumhub.repositories.mappers.toFavoriteRecipeDto
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val sharedPreferenceImpl: SharedPreferenceService,
    private val localDataSource: LocalDataSource
) : UserRepository {

    override suspend fun saveUserName(userData: UserInformationEntity) {
        val userInformation = userData.toUserInformation()
        val response = remoteDataSource.connectUser(userInformation)
        sharedPreferenceImpl.saveUserName(response.username!!)
        sharedPreferenceImpl.saveHash(response.hash!!)
    }

    override suspend fun getUserName(): String {
        return sharedPreferenceImpl.getUserName()!!
    }

    override suspend fun getHash(): String {
        return sharedPreferenceImpl.getHash() ?: throw NetworkException.UnAuthorizedException
    }

    override suspend fun saveCachingTimeStamp(key: String, cachingTime: Long) {
        sharedPreferenceImpl.saveLastCachingTimeStamp(key, cachingTime)
    }

    override suspend fun getLastCachingTimeStamp(key: String): Long {
        return sharedPreferenceImpl.getLastCachingTime(key)
    }

    override suspend fun getFavoriteRecipes(): List<RecipeEntity> {
        return localDataSource.getFavoriteRecipes().toEntityList()
    }

    override suspend fun saveFavoriteRecipe(recipe: RecipeEntity) {
        localDataSource.saveFavoriteRecipe(recipe.toFavoriteRecipeDto())
    }

    override suspend fun deleteFavoriteRecipe(recipe: RecipeEntity) {
        localDataSource.deleteFavoriteRecipe(recipe.toFavoriteRecipeDto())
    }

    override suspend fun clearFavoriteRecipes() {
        localDataSource.clearFavoriteRecipes()
    }


    private fun UserInformationEntity.toUserInformation(): UserInformationResource {
        return UserInformationResource(
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email
        )
    }
}