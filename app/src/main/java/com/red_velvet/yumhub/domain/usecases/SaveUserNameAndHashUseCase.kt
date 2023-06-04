package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.repositories.UserRepository
import com.red_velvet.yumhub.domain.models.UserInformation
import javax.inject.Inject

class SaveUserNameAndHashUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userData: UserInformation) {
        repository.saveUserName(userData)
    }
}