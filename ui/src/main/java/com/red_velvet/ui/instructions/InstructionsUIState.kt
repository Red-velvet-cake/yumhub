package com.red_velvet.ui.instructions

data class InstructionsUIState(
    val name: String? = "",
    val steps: List<StepsUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: com.red_velvet.ui.base.ErrorUIState? = null,
): com.red_velvet.ui.base.BaseUiState()
