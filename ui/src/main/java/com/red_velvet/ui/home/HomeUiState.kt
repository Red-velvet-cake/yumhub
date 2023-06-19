package com.red_velvet.ui.home

data class HomeUiState(
    val quickRecipesUiState: List<QuickRecipeUiState> = emptyList(),
    val popularRecipesUiState: List<RecipeUiState> = emptyList(),
    val healthyRecipesUiState: List<RecipeUiState> = emptyList(),
    val categoryRecipesUiState: List<RecipeUiState> = emptyList(),
    val error: com.red_velvet.ui.base.ErrorUIState? = null,
    val isLoading: Boolean = false
) : com.red_velvet.ui.base.BaseUiState()