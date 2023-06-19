package com.red_velvet.ui.home

import com.red_velvet.mylibrary.R


class QuickRecipeAdapter(
    items: List<QuickRecipeUiState>,
    listener: HomeInteractionListener
) : com.red_velvet.ui.base.BaseAdapter<QuickRecipeUiState>(items, listener) {
    override val layoutId = R.layout.item_quick_recipe
}