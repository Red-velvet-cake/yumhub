package com.red_velvet.yumhub.ui.main

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface MainUIEffect : BaseUIEffect {

    object NavigateToSignUp : MainUIEffect

    object NavigateToHome : MainUIEffect

}