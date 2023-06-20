package com.red_velvet.yumhub.ui.recipecategories

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.home.CategoryUiState

data class RecipeCategoriesUiState(
    val categoriesList: List<CategoryUiState> = emptyList(),
    val error: ErrorUIState? = null,
    val isLoading: Boolean = false
) : BaseUiState()