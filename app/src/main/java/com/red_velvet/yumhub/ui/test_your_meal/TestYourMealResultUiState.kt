package com.red_velvet.yumhub.ui.test_your_meal

import com.red_velvet.yumhub.ui.base.BaseUiState

data class TestYourMealResultUiState(
    val amount: String,
    val indented: Boolean,
    val name: String,
    val DailyNeeds: Double
)