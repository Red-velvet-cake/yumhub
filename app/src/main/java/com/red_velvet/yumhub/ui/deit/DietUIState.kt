package com.red_velvet.yumhub.ui.deit

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.search.SearchResultUIState

data class DietUIState(
    val type : String="",
    val dietResult: List<DietResultUIState> = emptyList(),
    val isLoading :Boolean=false,
    val error : ErrorUIState? = null,
):BaseUiState()