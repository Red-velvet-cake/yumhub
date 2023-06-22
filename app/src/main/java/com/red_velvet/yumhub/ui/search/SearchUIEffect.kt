package com.red_velvet.yumhub.ui.search

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface SearchUIEffect : BaseUIEffect {

    data class ClickOnRecipe(val recipeId: Int) : SearchUIEffect

}