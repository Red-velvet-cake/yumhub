package com.red_velvet.yumhub.ui.instructions

data class StepsUiState(
    val name: String? = "Initial Instructions",
    val stepNumber: Int? = 1,
    val stepDetails: String?
)
