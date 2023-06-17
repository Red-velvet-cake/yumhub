package com.red_velvet.yumhub.ui.home.listeners

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface HealthyRecipeInteractionListener : BaseInteractionListener {

    fun doOnHealthyRecipeClicked(recipeId: Int)

    fun doOnClickSeeAllHealthyRecipes()

}