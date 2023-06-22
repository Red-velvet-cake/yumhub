package com.red_velvet.yumhub.ui.home.adapters


import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.home.CategoryUiState
import com.red_velvet.yumhub.ui.home.listeners.CategoryInteractionListener

class RecipesCategoriesAdapter(
    items: List<CategoryUiState>,
    listener: CategoryInteractionListener
) : BaseAdapter<CategoryUiState>(items, listener) {
    override val layoutId = R.layout.item_home_recipe_categories
}