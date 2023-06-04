package com.red_velvet.yumhub.domain.usecases

import javax.inject.Inject

class ValidateLastNameUseCase @Inject constructor() {
    operator fun invoke(lastName: String): String? {
        return if (lastName.isBlank()) "Last name is required" else null
    }
}