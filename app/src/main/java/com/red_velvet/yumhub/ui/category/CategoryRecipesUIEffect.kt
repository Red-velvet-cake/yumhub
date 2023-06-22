package com.red_velvet.yumhub.ui.category

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface CategoryRecipesUIEffect : BaseUIEffect {

    data class ClickOnRecipe(val id: Int) : CategoryRecipesUIEffect

}