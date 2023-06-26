package com.red_velvet.yumhub.ui.favorites

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed class FavoritesUiEffect : BaseUIEffect {

    data class ClickOnRecipe(val id: Int) : FavoritesUiEffect()
}