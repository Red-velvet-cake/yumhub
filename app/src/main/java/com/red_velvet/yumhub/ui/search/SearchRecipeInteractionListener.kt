package com.red_velvet.yumhub.ui.search

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface SearchRecipeInteractionListener : BaseInteractionListener {
    fun doOnRecipeClicked(recipeId: Int)
}