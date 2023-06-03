package com.red_velvet.yumhub.ui.signUp

data class SignUpUIState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errors: String = "",
    val isSignUpButtonClicked: Boolean = false,
)
