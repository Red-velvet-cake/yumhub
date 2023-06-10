package com.red_velvet.yumhub.ui.home

data class HomeUiState(
    val quickRecipesUiState: List<QuickRecipeUiState> = emptyList(),
    val popularRecipesUiState: List<RecipeUiState> = emptyList(),
    val healthyRecipesUiState: List<RecipeUiState> = emptyList(),
    val categoryRecipesUiState: List<RecipeUiState> = emptyList(),
    val errors: List<String> = emptyList(),
    val isLoading: Boolean = false,
)