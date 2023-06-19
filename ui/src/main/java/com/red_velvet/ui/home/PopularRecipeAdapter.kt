package com.red_velvet.ui.home

import com.red_velvet.mylibrary.R


class PopularRecipeAdapter(
    items: List<RecipeUiState>,
    listener: HomeInteractionListener
) : com.red_velvet.ui.base.BaseAdapter<RecipeUiState>(items, listener) {
    override val layoutId = R.layout.item_main_recipe
}