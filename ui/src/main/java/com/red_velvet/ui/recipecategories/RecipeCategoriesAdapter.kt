package com.red_velvet.ui.recipecategories

import com.red_velvet.mylibrary.R
import com.red_velvet.ui.home.RecipeUiState

class RecipeCategoriesAdapter(
    items: List<RecipeUiState>
) : com.red_velvet.ui.base.BaseAdapter<RecipeUiState>(items) {
    override val layoutId: Int = R.layout.item_recipe_categories
}