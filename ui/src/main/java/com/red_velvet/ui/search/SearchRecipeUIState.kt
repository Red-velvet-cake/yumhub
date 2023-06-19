package com.red_velvet.ui.search

data class SearchRecipeUIState(
    val searchInput :String ="",
    val sort : String="",
    val sortDirection : String="",
    val searchResult: List<SearchResultUIState> = emptyList(),
    val isLoading :Boolean=false,
    val isResultIsEmpty :Boolean=false,
    val error : com.red_velvet.ui.base.ErrorUIState? = null,
): com.red_velvet.ui.base.BaseUiState()
