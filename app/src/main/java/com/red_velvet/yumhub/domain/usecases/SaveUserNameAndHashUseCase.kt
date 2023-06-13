package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.UserInformationEntity
import com.red_velvet.yumhub.domain.repositories.UserRepository
import javax.inject.Inject

class SaveUserNameAndHashUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userData: UserInformationEntity) {
        repository.saveUserName(userData)
    }
}