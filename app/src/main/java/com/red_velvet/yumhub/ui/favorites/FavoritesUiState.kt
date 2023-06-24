package com.red_velvet.yumhub.ui.favorites

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class FavoritesUiState(
    val favoritesRecipes: List<RecipeUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: ErrorUIState? = null
) : BaseUiState {
    data class RecipeUiState(
        val id: Int = 0,
        val title: String = "",
        val image: String = "",
        val overview: String = "",
    )
}
