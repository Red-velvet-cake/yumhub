package com.red_velvet.yumhub.ui.onboarding

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface OnBoardingUIEffect : BaseUIEffect {

    object ClickOnGoToSignup : OnBoardingUIEffect

}