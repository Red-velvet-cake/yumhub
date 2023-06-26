package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.UserInformationEntity
import com.red_velvet.yumhub.domain.repositories.UserRepository
import com.red_velvet.yumhub.repositories.datasources.SharedPreferenceService
import javax.inject.Inject

class SaveUserNameAndHashUseCase @Inject constructor(
    private val repository: UserRepository,
    private val sharedPreferenceService: SharedPreferenceService
) {
    suspend operator fun invoke(name: String, apiKey: String) {
        sharedPreferenceService.saveApiKey(apiKey).also {
            repository.saveUserName(UserInformationEntity(name, name, name, name))
        }
    }
}