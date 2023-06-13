package com.red_velvet.yumhub.ui.search.SearchUISate

import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.ui.base.BaseUiState

data class SearchRecipeUIState(
    val searchInput: String = "",
    val recipeFilter: List<SearchRecipeFilterUIState> = emptyList(),
    val searchResult: List<SearchRecipeEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: List<String> = emptyList(),
) : BaseUiState()
