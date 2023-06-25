package com.red_velvet.yumhub.ui.favorites

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface FavoriteInteractionListener : BaseInteractionListener {

    fun onFavoriteRecipeClicked(id: Int)

    fun onFavoriteRecipeRemoved(recipe: RecipeEntity)

    fun onUndoRecipeRemoved(recipe: FavoritesUiState.RecipeUiState)
}