package com.red_velvet.yumhub.ui.ingredients

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class IngredientsUIState(
    val resultIngredient: List<ExtendedIngredientUIState> = emptyList(),
    val isLoading: Boolean = true,
    val error: ErrorUIState? = null
) : BaseUiState()

data class ExtendedIngredientUIState(
    val image: String,
    val original: String
)
