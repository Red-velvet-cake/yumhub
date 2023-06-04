package com.red_velvet.yumhub.domain.usecases

import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor() {
    operator fun invoke(email: String): String? {
        return if (email.isBlank()) "Email is required" else null
    }
}