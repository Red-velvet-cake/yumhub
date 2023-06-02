package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.remote.dtos.auth.UserInformation
import com.red_velvet.yumhub.data.repositories.UserRepositoryImpl
import javax.inject.Inject

class SaveUserNameAndHashUseCase @Inject constructor(
    private val repository: UserRepositoryImpl
) {

    suspend operator fun invoke(userData: UserInformation) {
        repository.saveUserName(userData)
    }
}