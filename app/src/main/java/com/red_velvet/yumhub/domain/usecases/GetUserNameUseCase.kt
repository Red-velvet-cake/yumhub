package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.repositories.UserRepository
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(): String {
        return repository.getUserName()
    }
}