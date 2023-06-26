package com.red_velvet.yumhub.ui.signUp

import com.red_velvet.yumhub.ui.base.BaseUIEffect
import com.red_velvet.yumhub.ui.base.ErrorUIState

sealed interface SignupUIEffect : BaseUIEffect {

    object LoggedInSuccessfully : SignupUIEffect

    data class ShowError(val error: ErrorUIState) : SignupUIEffect
}