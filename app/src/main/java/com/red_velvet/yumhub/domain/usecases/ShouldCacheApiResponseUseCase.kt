package com.red_velvet.yumhub.domain.usecases

import javax.inject.Inject

class ShouldCacheApiResponseUseCase @Inject constructor(
    private val getLastCachingTimeUseCae: GetLastCachingTimeUseCae,
    private val getCurrentTimestampUseCase: GetCurrentTimestampUseCase,
    private val refreshLastCachingTimeStamp: RefreshLastCachingTimeStamp
) {

    suspend operator fun invoke(key: String): Boolean {
        val lastCachingTime = getLastCachingTimeUseCae(key)
        val currentTime = getCurrentTimestampUseCase()
        val timeDifference = currentTime - lastCachingTime
        val twelveHoursInMillis = 12 * 60 * 60 * 1000
        return (timeDifference > twelveHoursInMillis).also { if (it) refreshLastCachingTimeStamp(key) }
    }

}