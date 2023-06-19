package com.red_velvet.repository

import com.red_velvet.repository.datasources.RemoteDataSource
import com.red_velvet.repository.datasources.SharedPreferenceService
import com.red_velvet.repository.resources.auth.UserInformationResource
import javax.inject.Inject

 class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val sharedPreferenceImpl: SharedPreferenceService
) : com.red_velvet.domain.repositories.UserRepository {

    override suspend fun saveUserName(userData: com.red_velvet.domain.models.UserInformationEntity) {
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


    private fun com.red_velvet.domain.models.UserInformationEntity.toUserInformation(): UserInformationResource {
        return UserInformationResource(
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email
        )
    }
}