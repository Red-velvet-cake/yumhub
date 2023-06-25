package com.red_velvet.yumhub.ui.favorites

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter


class FavoriteRecipesAdapter(
    items: List<FavoritesUiState.RecipeUiState>,
    private val listener: FavoriteInteractionListener
) : BaseAdapter<FavoritesUiState.RecipeUiState>(items, listener) {
    override val layoutId = R.layout.item_favorite

    fun removeItem(position: Int) {
        if (position in getItems().indices) {
            listener.onFavoriteRecipeRemoved(getItems()[position].toEntity())
        }
    }
}