package com.red_velvet.yumhub.ui.search

sealed interface SearchUIEffect {
    data class ClickOnRecipe(val id: Int) : SearchUIEffect
}