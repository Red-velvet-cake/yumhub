package com.red_velvet.yumhub.ui.category

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.BaseInteractionListener
import com.red_velvet.yumhub.ui.home.RecipeUiState

class RecipeCategoryAdapter(
    items: List<RecipeUiState>,
    listener: RecipeInteractionListener
) : BaseAdapter<RecipeUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_category_recipes

}

interface RecipeInteractionListener : BaseInteractionListener