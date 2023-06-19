package com.red_velvet.domain.usecases

import com.red_velvet.domain.repositories.UserRepository
import javax.inject.Inject

class RefreshLastCachingTimeStamp @Inject constructor(
    private val userRepository: UserRepository,
    private val getCurrentTimestampUseCase: GetCurrentTimestampUseCase
) {

    suspend operator fun invoke(key: String) {
        val currentTime = getCurrentTimestampUseCase()
        userRepository.saveCachingTimeStamp(key, currentTime)
    }
}