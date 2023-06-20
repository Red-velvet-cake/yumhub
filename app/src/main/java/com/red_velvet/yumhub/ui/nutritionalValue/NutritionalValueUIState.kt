package com.red_velvet.yumhub.ui.nutritionalValue

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class NutritionalValueUIState(
    val error: ErrorUIState? = null,
    val isLoading: Boolean = false,
    val calories: Int = 0,
    val carbs: Int = 0,
    val fat: Int = 0,
    val Protein: Int = 0,
):BaseUiState()