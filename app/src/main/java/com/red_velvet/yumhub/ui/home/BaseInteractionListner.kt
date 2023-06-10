package com.red_velvet.yumhub.ui.home

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun doOnCategoryClicked(categoryTitle: String)
    fun doOnPopularRecipeClicked(recipeId: Int)
}