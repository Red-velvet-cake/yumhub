package com.red_velvet.yumhub.ui.search

import com.red_velvet.yumhub.domain.models.recipes.SearchRecipe

data class SearchRecipeUIState(
    val searchInput :String ="",
    val recipeFilter : String="",
    val sortDirection : String="",
    val searchResult: List<SearchResultUIState> = emptyList(),
    val isLoading :Boolean=false,
    val isSearchStart :Boolean=false,
    val isClearField :Boolean=false,
    val isResultIsEmpty :Boolean=false,
    val error :List<String> = emptyList(),
)
