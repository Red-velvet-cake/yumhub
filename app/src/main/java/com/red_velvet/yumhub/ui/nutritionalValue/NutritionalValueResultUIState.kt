package com.red_velvet.yumhub.ui.nutritionalValue

import com.red_velvet.yumhub.ui.base.BaseUiState

data class NutritionalValueResultUIState (
    val calories: Double = 0.0,
    val carbs: Double = 0.0,
    val fat: Double = 0.0,
    val protein: Double = 0.0,
):BaseUiState()