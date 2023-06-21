package com.red_velvet.yumhub.ui.deit

sealed interface DietUIEffect{
    val recipeId: Int

    data class ClickOnRecipe(override val recipeId: Int) : DietUIEffect
}