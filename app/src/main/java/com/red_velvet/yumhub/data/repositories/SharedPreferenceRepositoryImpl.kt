package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.local.SharedPreferenceManager
import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.auth.UserInformation
import javax.inject.Inject

class SharedPreferenceRepositoryImpl @Inject constructor(
    private val foodServiceImpl: FoodService,
    private val sharedPreferenceManager: SharedPreferenceManager
) : SharedPreferenceRepository {

    override suspend fun saveUserName(userData: UserInformation) {
        val response = foodServiceImpl.connectUser(userData)
        if (response.isSuccessful) {
            val userData = response.body()
            sharedPreferenceManager.saveUserName(userData?.username!!)
            sharedPreferenceManager.saveHash(userData.hash!!)
        } else {
            throw Exception(response.message())
        }

    }

    override suspend fun getUserName(): String {
        return sharedPreferenceManager.getUserName()!!
    }

    override suspend fun getHash(): String {
        return sharedPreferenceManager.getHash()!!
    }
}