package com.red_velvet.yumhub.ui.deit

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface DietUIEffect : BaseUIEffect {
    data class ClickOnRecipe(val recipeId: Int) : DietUIEffect
}