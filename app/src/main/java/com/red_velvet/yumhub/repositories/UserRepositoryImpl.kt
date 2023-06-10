package com.red_velvet.yumhub.repositories

import com.red_velvet.yumhub.domain.models.UserInformationEntity
import com.red_velvet.yumhub.domain.repositories.UserRepository
import com.red_velvet.yumhub.local.SharedPreferenceService
import com.red_velvet.yumhub.remote.dtos.auth.UserInformationDto
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val sharedPreferenceImpl: SharedPreferenceService
) : UserRepository {

    override suspend fun saveUserName(userData: UserInformationEntity) {
       val userInformation = userData.toUserInformation()
        val response = remoteDataSource.connectUser(userInformation)
        if (response.isSuccessful) {
            val connectUserDto = response.body()
            sharedPreferenceImpl.saveUserName(connectUserDto?.username!!)
            sharedPreferenceImpl.saveHash(connectUserDto.hash!!)
        } else {
            throw Exception(response.message())
        }

    }

    override suspend fun getUserName(): String {
        return sharedPreferenceImpl.getUserName()!!
    }

    override suspend fun getHash(): String {
        return sharedPreferenceImpl.getHash()!!
    }


    private fun UserInformationEntity.toUserInformation():UserInformationDto {
        return UserInformationDto(
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email,
        )
    }
}