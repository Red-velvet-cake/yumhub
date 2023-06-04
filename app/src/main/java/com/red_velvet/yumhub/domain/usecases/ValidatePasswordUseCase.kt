package com.red_velvet.yumhub.domain.usecases

import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor() {
    operator fun invoke(password: String): String? {
        return if (password.isBlank()) "Password is required" else null
    }
}