package com.red_velvet.yumhub.ui.history

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class HistoryUIState(
    val searchResult: List<HistoryItemUIState> = emptyList(),
    val isResultIsEmpty: Boolean = false,
    val error: ErrorUIState? = null,
) : BaseUiState
