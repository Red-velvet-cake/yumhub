package com.red_velvet.yumhub.ui.recipecategories

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.home.RecipeUiState

class RecipeCategoriesAdapter(
    items: List<RecipeUiState>
) : BaseAdapter<RecipeUiState>(items) {
    override val layoutId: Int = R.layout.item_recipe_categories
}