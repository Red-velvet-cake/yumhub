package com.red_velvet.yumhub.ui.favorites

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class FavoritesUiState(
    val favorites: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val error: ErrorUIState? = null
) : BaseUiState
