package com.red_velvet.yumhub.ui.signUp

sealed interface SignupUIEffect {

    object LoggedInSuccessfully : SignupUIEffect

}