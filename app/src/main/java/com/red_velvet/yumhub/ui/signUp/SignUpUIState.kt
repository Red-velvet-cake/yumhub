package com.red_velvet.yumhub.ui.signUp

import com.red_velvet.yumhub.ui.base.BaseUiState

data class SignUpUIState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val username: String = "",
    val password: String = "",
    val usernameError: String? = null,
    val firstNameError: String? = null,
    val lastNameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val errors: String = "",
    val isSignUpButtonClicked: Boolean = false
) : BaseUiState()
