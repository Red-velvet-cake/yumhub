package com.red_velvet.yumhub.ui.recipecategories

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.home.RecipeUiState

data class RecipeCategoriesUiState(
    val recipesList: List<RecipeUiState> = emptyList(),
    val error: ErrorUIState? = null,
    val isLoading: Boolean = false
) : BaseUiState()