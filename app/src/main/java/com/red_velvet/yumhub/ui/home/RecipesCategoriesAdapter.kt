package com.red_velvet.yumhub.ui.home


import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter

class RecipesCategoriesAdapter(
    items: List<RecipeUiState>,
    listener: HomeInteractionListener
) : BaseAdapter<RecipeUiState>(items, listener) {
    override val layoutId = R.layout.item_home_recipe_categories
}