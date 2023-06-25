package com.red_velvet.yumhub.ui.recipecategories

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface RecipeCategoriesUIEffect : BaseUIEffect {

    data class ClickOnCategory(val categoryType: String) : RecipeCategoriesUIEffect

}