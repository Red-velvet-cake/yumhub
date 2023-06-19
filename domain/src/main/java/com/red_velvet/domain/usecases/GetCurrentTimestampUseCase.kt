package com.red_velvet.domain.usecases

import java.util.Date
import javax.inject.Inject

class GetCurrentTimestampUseCase @Inject constructor(
    private val date: Date
) {
    operator fun invoke(): Long {
        return date.time
    }
}