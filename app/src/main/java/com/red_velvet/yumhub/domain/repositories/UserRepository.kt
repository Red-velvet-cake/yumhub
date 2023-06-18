package com.red_velvet.yumhub.domain.repositories

import com.red_velvet.yumhub.domain.models.UserInformationEntity

interface UserRepository {

    suspend fun saveUserName(userData: UserInformationEntity)
    suspend fun getUserName(): String
    suspend fun getHash(): String

    suspend fun saveCachingTimeStamp(key: String, cachingTime: Long)

    suspend fun getLastCachingTimeStamp(key: String): Long

}