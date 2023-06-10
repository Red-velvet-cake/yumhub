package com.red_velvet.yumhub.domain.usecases

import com.red_velvet.yumhub.domain.models.UserInformation
import javax.inject.Inject

class SignUpValidation @Inject constructor() {

     fun isFormValid(state: UserInformation): Boolean {
        return state.username?.isNotBlank() ?: false &&
                state.firstName?.isNotBlank() ?: false &&
                state.lastName?.isNotBlank() ?: false &&
                state.email?.isNotBlank() ?: false
    }
     fun validateLastName(lastName: String): String? {
        return if (lastName.isBlank()) "Last name is required" else null
    }
    fun validateEmail(email: String): String? {
        return if (email.isBlank()) "Email is required" else null
    }
    fun validateFirstName(firstName: String): String? {
        return if (firstName.isBlank()) "First name is required" else null
    }
    fun validatePassword(password: String): String? {
        return if (password.isBlank()) "Password is required" else null
    }
    fun validateUsername(username: String): String? {
        return if (username.isBlank()) "Username is required" else null
    }
}