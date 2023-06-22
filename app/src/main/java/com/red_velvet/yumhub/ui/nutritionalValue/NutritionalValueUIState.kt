package com.red_velvet.yumhub.ui.nutritionalValue

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class NutritionalValueUIState(
    val error: ErrorUIState? = null,
    val isLoading: Boolean = false,
    val textInput: String = "",
    val nutritionalValueResultUIState: NutritionalValueResultUIState? = null
) : BaseUiState