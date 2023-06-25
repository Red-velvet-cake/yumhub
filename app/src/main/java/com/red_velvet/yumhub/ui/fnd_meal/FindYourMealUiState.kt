package com.red_velvet.yumhub.ui.fnd_meal

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.search.SearchResultUIState

data class FindYourMealUiState(
    val searchInput: String = "",
    val searchResult: List<SearchResultUIState> = emptyList(),
    val isLoading: Boolean = false,
    val isResultIsEmpty: Boolean = false,
    val error: ErrorUIState? = null,
) : BaseUiState

