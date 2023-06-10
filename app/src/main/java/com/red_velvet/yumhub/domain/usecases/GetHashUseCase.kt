package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.data.repositories.UserRepository
import javax.inject.Inject

class GetHashUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): String {
        return repository.getHash()
    }
}