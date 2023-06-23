package com.red_velvet.yumhub.ui.profile

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class ProfileUiState(
    val imageUrl: String = "",
    val name: String = "",
    val error: ErrorUIState? = null,
    val isLoading: Boolean = false
) : BaseUiState