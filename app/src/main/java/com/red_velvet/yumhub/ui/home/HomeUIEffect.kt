package com.red_velvet.yumhub.ui.home

sealed interface HomeUIEffect {

    data class ClickOnPopularRecipe(val id: Int) : HomeUIEffect

    data class ClickOnHealthyRecipe(val id: Int) : HomeUIEffect

    data class ClickOnQuickRecipe(val id: Int) : HomeUIEffect

    data class ClickOnSeeAllPopularRecipes(val type: Int) : HomeUIEffect

    data class ClickOnSeeAllHealthyRecipes(val type: Int) : HomeUIEffect

    data class ClickOnSeeAllQuickRecipes(val type: Int) : HomeUIEffect

    data class ClickOnCategory(val title: String) : HomeUIEffect

    object ClickOnSeeAllCategories : HomeUIEffect

}