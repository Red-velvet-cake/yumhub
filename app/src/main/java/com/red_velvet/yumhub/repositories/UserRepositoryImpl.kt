package com.red_velvet.yumhub.repositories

import com.red_velvet.yumhub.domain.models.UserInformationEntity
import com.red_velvet.yumhub.domain.repositories.UserRepository
import com.red_velvet.yumhub.remote.resources.auth.UserInformationResource
import com.red_velvet.yumhub.repositories.datasources.RemoteDataSource
import com.red_velvet.yumhub.repositories.datasources.SharedPreferenceService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val sharedPreferenceImpl: SharedPreferenceService
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
        return sharedPreferenceImpl.getHash()!!
    }

    override suspend fun saveCachingTimeStamp(key: String, cachingTime: Long) {
        sharedPreferenceImpl.saveLastCachingTimeStamp(key, cachingTime)
    }

    override suspend fun getLastCachingTimeStamp(key: String): Long {
        return sharedPreferenceImpl.getLastCachingTime(key)
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