package com.red_velvet.yumhub.ui.home.listeners

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface QuickRecipeInteractionListener : BaseInteractionListener {

    fun doOnQuickRecipeClicked(recipeId: Int)

    fun doOnClickSeeAllQuickRecipes(type: Int)

}