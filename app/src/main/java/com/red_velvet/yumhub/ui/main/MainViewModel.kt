package com.red_velvet.yumhub.ui.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.GetHashUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getHashUseCase: GetHashUseCase
) : BaseViewModel<MainUIState, MainUIEffect>(MainUIState()) {

    init {
        authenticateUser()
    }

    private fun authenticateUser() {
        tryToExecute(getHashUseCase::invoke, ::onGetUserHash, ::onError)
    }

    private fun onGetUserHash(userHash: String) {
        viewModelScope.launch { _effect.emit(MainUIEffect.NavigateToHome) }
    }

    private fun onError(errorUIState: ErrorUIState) {
        Log.d("alhams", "onGetUserHash: $errorUIState")

        when (errorUIState) {
            ErrorUIState.ConnectionTimeout -> {}
            ErrorUIState.InternalServerError -> {}
            ErrorUIState.NoInternet -> {}
            ErrorUIState.UnAuthorized -> {
                Log.d("alhams", "onError: ")
                viewModelScope.launch {
                    _effect.emit(MainUIEffect.NavigateToSignUp)
                }
            }
        }
    }

}