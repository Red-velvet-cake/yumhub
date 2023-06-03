package com.red_velvet.yumhub.domain.usecases

import java.util.Date
import javax.inject.Inject

class GetTimestampUseCase @Inject constructor(
    private val date: Date
) {
    operator fun invoke(): Long {
        return date.time
    }
}