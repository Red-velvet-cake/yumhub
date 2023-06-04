package com.red_velvet.yumhub.domain.usecases

import javax.inject.Inject

class ValidateFirstName @Inject constructor() {
    operator fun invoke(firstName: String): String? {
        return if (firstName.isBlank()) "First name is required" else null
    }
}