package com.red_velvet.domain.usecases

import com.red_velvet.domain.repositories.UserRepository
import javax.inject.Inject

class SaveUserNameAndHashUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userData: com.red_velvet.domain.models.UserInformationEntity) {
        repository.saveUserName(userData)
    }
}