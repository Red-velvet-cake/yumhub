package com.red_velvet.yumhub.ui.nutrition_info

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class NutritionInfoUiState(
    val goodContent: List<NutritionInfoResultUiState> = emptyList(),
    val badContent: List<NutritionInfoResultUiState> = emptyList(),
    val isLoading : Boolean = false,
    val error: ErrorUIState? = null
): BaseUiState{

    data class NutritionInfoResultUiState(
        val amount: String,
        val indented: Boolean,
        val name: String,
        val DailyNeeds: Double

    )
}
