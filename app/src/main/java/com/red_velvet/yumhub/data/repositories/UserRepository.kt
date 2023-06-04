package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.domain.models.UserInformation

interface UserRepository {

    suspend fun saveUserName(userData: UserInformation)
    suspend fun getUserName(): String
    suspend fun getHash(): String

}