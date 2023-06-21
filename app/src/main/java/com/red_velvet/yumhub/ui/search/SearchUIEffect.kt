package com.red_velvet.yumhub.ui.search

sealed interface SearchUIEffect {
     val recipeId: Int

    data class ClickOnRecipe(override val recipeId: Int) : SearchUIEffect
}