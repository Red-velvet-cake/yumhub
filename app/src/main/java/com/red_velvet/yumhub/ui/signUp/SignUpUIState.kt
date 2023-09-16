package com.red_velvet.yumhub.ui.signUp

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class SignUpUIState(
    val name: String = "",
    val apiKey: String = "",
    val isLoading: Boolean = false,
    val error: ErrorUIState? = null,
    val isValidName: Boolean = true,
    val isValidApiKey: Boolean = true
) : BaseUiState {
    val isValidForm: Boolean = isValidName && isValidApiKey
}
