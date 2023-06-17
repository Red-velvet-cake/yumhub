package com.red_velvet.yumhub.ui.main

sealed interface MainUIEffect {

    object NavigateToSignUp : MainUIEffect

    object NavigateToHome : MainUIEffect

}