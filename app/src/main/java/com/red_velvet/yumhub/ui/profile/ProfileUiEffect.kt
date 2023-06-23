package com.red_velvet.yumhub.ui.profile

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface ProfileUiEffect : BaseUIEffect {
    object ClickOnPersonalInfo : ProfileUiEffect

    object ClickOnChatBot : ProfileUiEffect

    object ClickOnReviewFood : ProfileUiEffect

    object ClickOnNutritionalValue : ProfileUiEffect

    object ClickOnFoodSuggester : ProfileUiEffect
}