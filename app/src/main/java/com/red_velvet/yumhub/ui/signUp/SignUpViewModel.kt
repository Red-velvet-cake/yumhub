package com.red_velvet.yumhub.ui.signUp

import com.red_velvet.yumhub.domain.models.UserInformationEntity
import com.red_velvet.yumhub.domain.usecases.SaveUserNameAndHashUseCase
import com.red_velvet.yumhub.domain.usecases.SignUpValidation
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val saveUserInformation: SaveUserNameAndHashUseCase,
    private val signUpValidation: SignUpValidation,
) : BaseViewModel<SignUpUIState>(SignUpUIState()) {

    private val _uiState = MutableStateFlow(SignUpUIState())
    val uiState: StateFlow<SignUpUIState> = _uiState

    fun onUsernameChange(username: String) {
        _uiState.update { it.copy(username = username, usernameError = null) }
    }

    fun onFirstNameChange(firstName: String) {
        _uiState.update { it.copy(firstName = firstName, firstNameError = null) }
    }

    fun onLastNameChange(lastName: String) {
        _uiState.update { it.copy(lastName = lastName, lastNameError = null) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email, emailError = null) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password, passwordError = null) }
    }

    fun onSignUpButtonClicked() {
        val currentState = _uiState.value
        _state.update { it.copy(isLoading = true, isSignUpButtonClicked = true) }
        if (signUpValidation.isFormValid(currentState.toUserInformation())) {
            tryToExecute(
                { saveUserInformation.invoke(currentState.toUserInformation()) },
                onSuccess = ::onSignUpSuccess,
                onError = ::onError
            )
        } else {
            updateValidationErrors(currentState)
        }
    }

    private fun onSignUpSuccess(unit:Unit) {
        _uiState.update { it.copy(isLoading = false) }
    }

    private fun onError(errorUiState: ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    private fun updateValidationErrors(state: SignUpUIState) {
        _uiState.update {
            it.copy(
                usernameError = signUpValidation.validateUsername(state.username),
                firstNameError = signUpValidation.validateFirstName(state.firstName),
                lastNameError = signUpValidation.validateLastName(state.lastName),
                emailError = signUpValidation.validateEmail(state.email),
                passwordError = signUpValidation.validatePassword(state.password)
            )
        }
    }

    private fun SignUpUIState.toUserInformation(): UserInformationEntity {
        return UserInformationEntity(
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email,
        )
    }


}