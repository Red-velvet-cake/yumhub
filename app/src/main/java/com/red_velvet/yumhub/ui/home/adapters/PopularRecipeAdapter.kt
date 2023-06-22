package com.red_velvet.yumhub.ui.home.adapters


import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.home.RecipeUiState
import com.red_velvet.yumhub.ui.home.listeners.RecipeInteractionListener

class PopularRecipeAdapter(
    items: List<RecipeUiState>,
    listener: RecipeInteractionListener
) : BaseAdapter<RecipeUiState>(items, listener) {
    override val layoutId = R.layout.item_main_recipe
}