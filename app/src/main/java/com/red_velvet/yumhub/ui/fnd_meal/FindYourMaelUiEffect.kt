package com.red_velvet.yumhub.ui.fnd_meal

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface FindYourMaelUiEffect: BaseUIEffect {
    data class ClickOnResultItem(val recipeId: Int) : FindYourMaelUiEffect
}