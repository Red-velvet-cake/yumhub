package com.red_velvet.yumhub.ui.favorites

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.databinding.SnackbarFavoritesUndoBinding
import com.red_velvet.yumhub.ui.base.BaseAdapter

class FavoriteRecipesAdapter(
    items: List<FavoritesUiState.RecipeUiState>,
    private val listener: FavoriteInteractionListener
) : BaseAdapter<FavoritesUiState.RecipeUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_favorite

    fun removeItem(position: Int) {
        if (position in getItems().indices) {
            listener.onFavoriteRecipeRemoved(getItems()[position].toEntity())
        }
    }

    fun showUndoSnackBar(view: View, item: FavoritesUiState.RecipeUiState) {
        val snackBar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)

        val customSnackBarBinding = SnackbarFavoritesUndoBinding.inflate(
            LayoutInflater.from(view.context),
            null,
            false
        )

        snackBar.view.setBackgroundColor(Color.TRANSPARENT)
        snackBar.view.setPadding(16, 16, 16, 56)
        snackBar.view.alpha = 1.0f

        val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout
        snackBarLayout.addView(customSnackBarBinding.root)

        snackBar.show()

        customSnackBarBinding.textAction.setOnClickListener {
            listener.onUndoRecipeRemoved(item)
            snackBar.dismiss()
        }
    }
}
