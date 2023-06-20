package com.red_velvet.yumhub.ui.home.listeners

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface CategoryInteractionListener : BaseInteractionListener {

    fun doOnCategoryClicked(categoryTitle: String)

    fun doOnClickSeeAllCategoryRecipes()

}