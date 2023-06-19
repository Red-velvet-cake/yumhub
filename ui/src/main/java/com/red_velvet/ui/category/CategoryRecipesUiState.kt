package com.red_velvet.ui.category

import com.red_velvet.ui.home.RecipeUiState

data class CategoryRecipesUiState(
    val recipesList: List<RecipeUiState> = emptyList(),
    val error: com.red_velvet.ui.base.ErrorUIState? = null,
    val isLoading: Boolean = false
) : com.red_velvet.ui.base.BaseUiState()
