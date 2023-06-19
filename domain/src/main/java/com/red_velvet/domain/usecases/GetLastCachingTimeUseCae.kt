package com.red_velvet.domain.usecases

import com.red_velvet.domain.repositories.UserRepository
import javax.inject.Inject

class GetLastCachingTimeUseCae @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(key: String): Long {
        return userRepository.getLastCachingTimeStamp(key)
    }

}