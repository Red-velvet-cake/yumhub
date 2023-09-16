package com.red_velvet.yumhub.ui.home

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class HomeUiState(
    val name: String = "",
    val quickRecipesUiState: List<QuickRecipeUiState> = emptyList(),
    val popularRecipesUiState: List<RecipeUiState> = emptyList(),
    val healthyRecipesUiState: List<RecipeUiState> = emptyList(),
    val categoryRecipesUiState: List<CategoryUiState> = emptyList(),
    val sliderImagesList: List<HomeSliderItemUiState> = emptyList(),
    val error: ErrorUIState? = null,
    val isCategoryLoading: Boolean = true,
    val isQuickRecipesLoading: Boolean = true,
    val isPopularRecipesLoading: Boolean = true,
    val isHealthyRecipesLoading: Boolean = true,
    val isSliderLoading: Boolean = true,
    val isLoading: Boolean = true
) : BaseUiState