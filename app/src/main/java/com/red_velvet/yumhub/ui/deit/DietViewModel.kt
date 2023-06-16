package com.red_velvet.yumhub.ui.deit

import com.red_velvet.yumhub.domain.usecases.recipes.SearchRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.search.SearchRecipeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DietViewModel @Inject constructor(
    private val searchRecipeUseCase: SearchRecipeUseCase,
)  : BaseViewModel<DietUIState>(DietUIState()) {
    private val _uiState = MutableStateFlow(DietUIState())
    val uiState: StateFlow<DietUIState> = _uiState
}