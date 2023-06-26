package com.red_velvet.yumhub.ui.home.listeners

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface RecipeInteractionListener : BaseInteractionListener {

    fun doOnRecipeClicked(recipeId: Int)

    fun doOnClickSeeAllRecipes(type: Int)

}