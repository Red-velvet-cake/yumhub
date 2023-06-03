package com.red_velvet.yumhub.ui.search.SearchUISate

import com.red_velvet.yumhub.domain.models.recipes.SearchRecipe

data class SearchRecipeUIState(
    val searchInput :String ="",
    val recipeFilter : List<SearchRecipeFilterUIState> = emptyList(),
    val searchResult: List<SearchRecipe> = emptyList(),
    val isLoading :Boolean=false,
    val error :List<String> = emptyList(),
)
