package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.local.SharedPreferenceService
import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.auth.UserInformationDto
import com.red_velvet.yumhub.domain.models.UserInformation
import com.red_velvet.yumhub.domain.utils.ExceptionHandler
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val foodServiceImpl: FoodService,
    private val sharedPreferenceImpl: SharedPreferenceService,
    private val exception: ExceptionHandler
) : UserRepository {

    override suspend fun saveUserName(userData: UserInformation) {
       val userInformation = userData.toUserInformation()
        val response = foodServiceImpl.connectUser(userInformation)
        if (response.isSuccessful) {
            val connectUserDto = response.body()
            sharedPreferenceImpl.saveUserName(connectUserDto?.username!!)
            sharedPreferenceImpl.saveHash(connectUserDto.hash!!)
        } else {
            throw exception.getException(response.code(), response.errorBody())
        }

    }

    override suspend fun getUserName(): String {
        return sharedPreferenceImpl.getUserName()!!
    }

    override suspend fun getHash(): String {
        return sharedPreferenceImpl.getHash()!!
    }


    private fun UserInformation.toUserInformation(): UserInformationDto {
        return UserInformationDto(
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email,
        )
    }
}