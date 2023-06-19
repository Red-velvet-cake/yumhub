package com.red_velvet.ui.onboarding

import com.red_velvet.ui.base.BaseUiState

data class OnBoardingUIState(
    val isFirstTab:Boolean = true,
    val isSecondTab:Boolean = false,
    val isLastTab:Boolean = false,
): BaseUiState()
