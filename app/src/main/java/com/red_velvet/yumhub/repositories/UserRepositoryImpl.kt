package com.red_velvet.yumhub.repositories

import com.red_velvet.yumhub.domain.models.UserInformationEntity
import com.red_velvet.yumhub.domain.repositories.UserRepository
import com.red_velvet.yumhub.remote.resources.auth.UserInformationResource
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


    private fun UserInformationEntity.toUserInformation(): UserInformationResource {
        return UserInformationResource(
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email
        )
    }
}