package com.red_velvet.yumhub.ui.test_your_meal

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState
import java.lang.Error

data class TestYourMealUiState(
    val amount: String = "",
    val name: String = "",
    val DailyNeeds: Double = 0.0,
    val isLoading : Boolean = false,
    val error: ErrorUIState? = null
): BaseUiState