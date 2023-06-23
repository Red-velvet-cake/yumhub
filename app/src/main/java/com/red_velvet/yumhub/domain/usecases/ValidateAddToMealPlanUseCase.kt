package com.red_velvet.yumhub.domain.usecases

import javax.inject.Inject

class ValidateAddToMealPlanUseCase @Inject constructor() {

    operator fun invoke(timeStamp: Long): Boolean {
        return timeStamp != 0L
    }
}