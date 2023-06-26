package com.red_velvet.yumhub.ui.onboarding

import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor() :
    BaseViewModel<OnBoardingUIState, OnBoardingUIEffect>(OnBoardingUIState()),
    OnBoardingInteractionListener {

    override fun onClickNext() {
        if (_state.value.isSecondTab) {
            _state.update {
                it.copy(isFirstTab = false, isSecondTab = false, isLastTab = true)
            }
        } else {
            _state.update {
                it.copy(isFirstTab = false, isSecondTab = true)
            }
        }
    }
}