package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.repositories.UserRepository
import com.red_velvet.yumhub.domain.models.UserInformationEntity
import javax.inject.Inject

class SaveUserNameAndHashUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userData: UserInformationEntity) {
        repository.saveUserName(userData)
    }
}