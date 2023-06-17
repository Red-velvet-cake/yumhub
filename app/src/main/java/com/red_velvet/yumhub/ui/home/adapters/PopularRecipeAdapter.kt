package com.red_velvet.yumhub.ui.home.adapters


import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.home.RecipeUiState
import com.red_velvet.yumhub.ui.home.listeners.CategoryInteractionListener

class PopularRecipeAdapter(
    items: List<RecipeUiState>,
    listener: CategoryInteractionListener
) : BaseAdapter<RecipeUiState>(items, listener) {
    override val layoutId = R.layout.item_main_recipe
}