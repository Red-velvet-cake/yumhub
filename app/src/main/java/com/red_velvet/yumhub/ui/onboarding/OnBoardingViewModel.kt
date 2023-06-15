package com.red_velvet.yumhub.ui.onboarding

import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.search.SearchRecipeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel  @Inject constructor() :BaseViewModel<OnBoardingUIState>(OnBoardingUIState()){
    private  val _uiState = MutableStateFlow(OnBoardingUIState())
    val uiState : StateFlow<OnBoardingUIState> = _uiState
}