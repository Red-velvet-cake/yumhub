package com.red_velvet.yumhub.domain.usecases

import javax.inject.Inject

class ValidateUsernameUseCase @Inject constructor() {
     operator fun invoke(username: String): String? {
        return if (username.isBlank()) "Username is required" else null
    }
}