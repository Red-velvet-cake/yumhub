package com.red_velvet.yumhub.ui.onboarding

import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor() :
    BaseViewModel<OnBoardingUIState, OnBoardingUIEffect>(OnBoardingUIState()),
    OnBoardingInteractionListener {

    private val _uiState = MutableStateFlow(OnBoardingUIState())
    val uiState: StateFlow<OnBoardingUIState> = _uiState

    override fun onClickNext() {
        if (_uiState.value.isSecondTab) {
            _uiState.update {
                it.copy(isFirstTab = false, isSecondTab = false, isLastTab = true)
            }
        } else {
            _uiState.update {
                it.copy(isFirstTab = false, isSecondTab = true)
            }
        }
    }
}