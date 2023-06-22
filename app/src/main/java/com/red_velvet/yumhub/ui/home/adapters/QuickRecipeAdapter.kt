package com.red_velvet.yumhub.ui.home.adapters


import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.home.QuickRecipeUiState
import com.red_velvet.yumhub.ui.home.listeners.RecipeInteractionListener

class QuickRecipeAdapter(
    items: List<QuickRecipeUiState>,
    listener: RecipeInteractionListener
) : BaseAdapter<QuickRecipeUiState>(items, listener) {
    override val layoutId = R.layout.item_quick_recipe
}