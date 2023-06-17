package com.red_velvet.yumhub.ui.home.listeners

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface PopularRecipeInteractionListener : BaseInteractionListener {

    fun doOnPopularRecipeClicked(recipeId: Int)

    fun doOnClickSeeAllPopularRecipes()

}