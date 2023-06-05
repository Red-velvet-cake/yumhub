package com.red_velvet.yumhub.ui.search.SearchUISate

import com.red_velvet.yumhub.domain.models.recipes.SearchRecipe

data class SearchRecipeUIState(
    val searchInput :String ="",
    val recipeFilter : List<SearchRecipeFilterUIState> = emptyList(),
    val searchResult: List<SearchRecipe> = emptyList(),
    val isLoading :Boolean=false,
    val error :List<String> = emptyList(),
){
    data class SearchRecipeFilterUIState(
        val type:String,
        val isSelected:Boolean
    )
    data class RecipeSearchResultUIState(
        val id:Int?,
        val title:String?,
        val image:String?
    )
}
