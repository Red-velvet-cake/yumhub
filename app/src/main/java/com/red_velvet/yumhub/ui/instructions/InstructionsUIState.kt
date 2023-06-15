package com.red_velvet.yumhub.ui.instructions

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class InstructionsUIState(
    val name: String = "",
    val steps: List<StepsUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: ErrorUIState? = null,
):BaseUiState()
