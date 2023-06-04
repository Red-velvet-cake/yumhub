package com.red_velvet.yumhub.ui.home.uistate

data class HomeUiState(
    val quickRecipesUiState: List<RecipeUiState> = emptyList(),
    val popularRecipesUiState: List<RecipeUiState> = emptyList(),
    val healthyRecipesUiState: List<RecipeUiState> = emptyList(),
    val errors: List<String> = emptyList(),
    val isLoading: Boolean = false,
)