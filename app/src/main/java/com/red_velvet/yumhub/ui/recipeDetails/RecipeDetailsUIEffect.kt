package com.red_velvet.yumhub.ui.recipeDetails

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface RecipeDetailsUIEffect : BaseUIEffect {

    data class ClickOnDishType(val type: String) : RecipeDetailsUIEffect

    data class ClickOnGoToCookingSteps(val recipeId: Int) : RecipeDetailsUIEffect

    data class ClickAddToMealPlan(val recipeId: Int) : RecipeDetailsUIEffect

}