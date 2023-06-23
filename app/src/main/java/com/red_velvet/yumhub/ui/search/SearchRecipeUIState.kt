package com.red_velvet.yumhub.ui.search

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class SearchRecipeUIState(
    val searchInput: String = "",
    val sort: String = "",
    val sortDirection: String = "",
    val searchResult: List<SearchResultUIState> = emptyList(),
    val isLoading: Boolean = false,
    val isResultIsEmpty: Boolean = false,
    val error: ErrorUIState? = null,
) : BaseUiState
