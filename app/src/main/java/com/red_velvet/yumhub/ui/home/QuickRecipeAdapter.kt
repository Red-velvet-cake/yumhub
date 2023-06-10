package com.red_velvet.yumhub.ui.home


import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter

class QuickRecipeAdapter(
    items: List<QuickRecipeUiState>,
    listener: HomeInteractionListener
) : BaseAdapter<QuickRecipeUiState>(items, listener) {
    override val layoutId = R.layout.item_quick_recipe
}