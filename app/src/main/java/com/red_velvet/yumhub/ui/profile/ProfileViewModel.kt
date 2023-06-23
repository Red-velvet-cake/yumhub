package com.red_velvet.yumhub.ui.profile

import com.red_velvet.yumhub.domain.usecases.GetUserNameUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUsername: GetUserNameUseCase
) : BaseViewModel<ProfileUiState, ProfileUiEffect>(ProfileUiState()) {

    init {
        getUsername()
    }

    private fun getUsername() {
        tryToExecute(
            callee = getUsername::invoke,
            onSuccess = ::onGetUsernameSuccess,
            onError = ::onError
        )
    }

    private fun onGetUsernameSuccess(name: String) {
        _state.update {
            it.copy(username = name)
        }
    }

    private fun onError(error: ErrorUIState) {
        _state.update {
            it.copy(error = error)
        }
    }

}