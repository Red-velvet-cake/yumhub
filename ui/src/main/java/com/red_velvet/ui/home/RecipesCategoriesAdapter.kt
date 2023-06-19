package com.red_velvet.ui.home

import com.red_velvet.mylibrary.R


class RecipesCategoriesAdapter(
    items: List<RecipeUiState>,
    listener: HomeInteractionListener
) : com.red_velvet.ui.base.BaseAdapter<RecipeUiState>(items, listener) {
    override val layoutId = R.layout.item_home_recipe_categories
}