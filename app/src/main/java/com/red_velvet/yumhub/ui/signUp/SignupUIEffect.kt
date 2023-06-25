package com.red_velvet.yumhub.ui.signUp

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface SignupUIEffect : BaseUIEffect {

    object LoggedInSuccessfully : SignupUIEffect

}