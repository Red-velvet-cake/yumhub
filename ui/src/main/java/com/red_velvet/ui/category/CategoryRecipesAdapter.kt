package com.red_velvet.ui.category

import com.red_velvet.mylibrary.R
import com.red_velvet.ui.home.RecipeUiState

class CategoryRecipesAdapter(
    items: List<RecipeUiState>,
    listener: RecipeInteractionListener
) : com.red_velvet.ui.base.BaseAdapter<RecipeUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_category_recipes

}

interface RecipeInteractionListener : com.red_velvet.ui.base.BaseInteractionListener