package com.red_velvet.yumhub.ui.signUp

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.SaveUserNameAndHashUseCase
import com.red_velvet.yumhub.domain.usecases.SignUpValidationUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val saveUserInformation: SaveUserNameAndHashUseCase,
    private val signUpValidation: SignUpValidationUseCase,
) : BaseViewModel<SignUpUIState, SignupUIEffect>(SignUpUIState()) {

    fun onNameChange(name: String) {
        _state.update { it.copy(name = name, isValidName = onValidateName(name)) }
    }

    fun onApiKeyChange(apiKey: String) {
        _state.update { it.copy(apiKey = apiKey, isValidApiKey = onValidateApiKey(apiKey)) }
    }

    private fun onValidateName(name: String): Boolean {
        return signUpValidation.validateName(name)
    }

    private fun onValidateApiKey(apiKey: String): Boolean {
        return signUpValidation.validateApiKey(apiKey)
    }

    fun onSignupButtonClicked() {
        val currentState = _state.value
        _state.update { it.copy(isLoading = true) }
        if (onValidateName(currentState.name) && onValidateApiKey(currentState.apiKey)) {
            tryToExecute(
                { saveUserInformation(currentState.name, currentState.apiKey) },
                onSuccess = ::onSignUpSuccess,
                onError = ::onError
            )
        } else {
            _state.update { it.copy(isLoading = false) }
        }
    }

    private fun onSignUpSuccess(unit: Unit) {
        viewModelScope.launch { _effect.emit(SignupUIEffect.LoggedInSuccessfully) }
        _state.update { it.copy(isLoading = false) }
    }

    private fun onError(errorUiState: ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

}