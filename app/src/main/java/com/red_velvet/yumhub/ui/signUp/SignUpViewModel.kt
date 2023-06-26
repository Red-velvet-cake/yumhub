package com.red_velvet.yumhub.ui.signUp

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.SaveUserNameAndHashUseCase
import com.red_velvet.yumhub.domain.usecases.SignUpValidationUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val saveUserInformation: SaveUserNameAndHashUseCase,
    private val signUpValidation: SignUpValidationUseCase,
) : BaseViewModel<SignUpUIState, SignupUIEffect>(SignUpUIState()) {

    private var signupJob: Job? = null

    fun onNameChange(name: String) {
        _state.update {
            it.copy(
                name = name,
                isValidName = signUpValidation.validateName(name)
            )
        }
    }

    fun onApiKeyChange(apiKey: String) {
        _state.update {
            it.copy(
                apiKey = apiKey,
                isValidApiKey = signUpValidation.validateApiKey(apiKey)
            )
        }
    }

    fun onSignUpButtonClicked() {
        if (signupJob == null || signupJob?.isCompleted == true) {
            trySignUp()
        }
    }

    private fun trySignUp() {
        _state.update { it.copy(isLoading = true) }
        val currentState = _state.value
        if (signUpValidation.validateForm(currentState.name, currentState.apiKey)) {
            signupJob = tryToExecute(
                { saveUserInformation(currentState.name, currentState.apiKey) },
                ::onSignUpSuccess,
                ::onError
            )
        } else {
            _state.update { it.copy(isLoading = false, isValidApiKey = false, isValidName = false) }
        }
    }

    private fun onSignUpSuccess(unit: Unit) {
        viewModelScope.launch { _effect.emit(SignupUIEffect.LoggedInSuccessfully) }
        _state.update { it.copy(isLoading = false) }
    }

    private fun onError(errorUiState: ErrorUIState) {
        viewModelScope.launch { _effect.emit(SignupUIEffect.ShowError(errorUiState)) }
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

}