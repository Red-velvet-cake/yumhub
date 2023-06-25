package com.red_velvet.yumhub.ui.profile

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface ProfileUiEffect : BaseUIEffect {
    object ClickOnSettings : ProfileUiEffect

    object ClickOnChatBot : ProfileUiEffect

    object ClickOnFavorites : ProfileUiEffect

    object ClickOnHistory : ProfileUiEffect

    object ClickOnNutritionalValue : ProfileUiEffect

    object ClickOnFoodSuggester : ProfileUiEffect

    object ClickOnMealTest : ProfileUiEffect
}