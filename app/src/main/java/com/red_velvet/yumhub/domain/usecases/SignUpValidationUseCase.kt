package com.red_velvet.yumhub.domain.usecases

import javax.inject.Inject

class SignUpValidationUseCase @Inject constructor() {

    fun validateName(name: String): Boolean {
        val regex = Regex("[a-zA-Z]{3,}")
        return regex.matches(name)
    }

    fun validateApiKey(apiKey: String): Boolean {
        val regex = Regex("[a-fA-F0-9]{32}")
        return regex.matches(apiKey)
    }
}