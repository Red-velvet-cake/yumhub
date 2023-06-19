package com.red_velvet.ui.signUp



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
    val error: com.red_velvet.ui.base.ErrorUIState? = null,
    val isSignUpButtonClicked: Boolean = false
) : com.red_velvet.ui.base.BaseUiState()
