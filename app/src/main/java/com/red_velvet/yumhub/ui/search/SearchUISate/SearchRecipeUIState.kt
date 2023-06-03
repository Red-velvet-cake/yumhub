package com.red_velvet.yumhub.ui.search.SearchUISate

data class SearchRecipeUIState(
    val searchInput :String ="",
    val recipeFilter : List<SearchRecipeFilterUIState> = emptyList(),
    val searchResult: List<RecipeSearchResultUIState> = emptyList(),
    val isLoading :Boolean=false,
    val error :List<ErrorSearchUIState> = emptyList(),
)
