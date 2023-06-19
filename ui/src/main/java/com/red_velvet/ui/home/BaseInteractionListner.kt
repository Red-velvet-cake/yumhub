package com.red_velvet.ui.home

import com.red_velvet.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun doOnCategoryClicked(categoryTitle: String)
    fun doOnPopularRecipeClicked(recipeId: Int)
}