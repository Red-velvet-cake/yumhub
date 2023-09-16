package com.red_velvet.yumhub.ui.home

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface HomeUIEffect : BaseUIEffect {

    data class ClickOnRecipe(val id: Int) : HomeUIEffect

    data class ClickOnSeeAllPopularRecipes(val type: Int) : HomeUIEffect

    data class ClickOnSeeAllHealthyRecipes(val type: Int) : HomeUIEffect

    data class ClickOnSeeAllQuickRecipes(val type: Int) : HomeUIEffect

    data class ClickOnCategory(val title: String) : HomeUIEffect

    object ClickOnSeeAllCategories : HomeUIEffect

}