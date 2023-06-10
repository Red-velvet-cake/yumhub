package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.domain.models.UserInformationEntity

interface UserRepository {

    suspend fun saveUserName(userData: UserInformationEntity)
    suspend fun getUserName(): String
    suspend fun getHash(): String

}