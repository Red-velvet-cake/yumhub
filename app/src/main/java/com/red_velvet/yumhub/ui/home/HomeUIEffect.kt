package com.red_velvet.yumhub.ui.home

sealed interface HomeUIEffect {

    data class ClickOnPopularRecipe(val id: Int) : HomeUIEffect

    data class ClickOnHealthyRecipe(val id: Int) : HomeUIEffect

    data class ClickOnQuickRecipe(val id: Int) : HomeUIEffect

    object ClickOnSeeAllPopularRecipes : HomeUIEffect

    object ClickOnSeeAllHealthyRecipes : HomeUIEffect

    object ClickOnSeeAllQuickRecipes : HomeUIEffect

    data class ClickOnCategory(val title: String) : HomeUIEffect

    object ClickOnSeeAllCategories : HomeUIEffect

}