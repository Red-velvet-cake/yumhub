package com.red_velvet.ui.signUp

import com.red_velvet.domain.usecases.SaveUserNameAndHashUseCase
import com.red_velvet.domain.usecases.SignUpValidation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val saveUserInformation: SaveUserNameAndHashUseCase,
    private val signUpValidation: SignUpValidation,
) : com.red_velvet.ui.base.BaseViewModel<SignUpUIState>(SignUpUIState()) {

    fun onUsernameChange(username: String) {
        _state.update { it.copy(username = username, usernameError = null) }
    }

    fun onFirstNameChange(firstName: String) {
        _state.update { it.copy(firstName = firstName, firstNameError = null) }
    }

    fun onLastNameChange(lastName: String) {
        _state.update { it.copy(lastName = lastName, lastNameError = null) }
    }

    fun onEmailChange(email: String) {
        _state.update { it.copy(email = email, emailError = null) }
    }

    fun onPasswordChange(password: String) {
        _state.update { it.copy(password = password, passwordError = null) }
    }

    fun onSignUpButtonClicked() {
        val currentState = _state.value
        _state.update { it.copy(isLoading = true, isSignUpButtonClicked = true) }
        if (signUpValidation.isFormValid(currentState.toUserInformation())) {
            tryToExecute(
                { saveUserInformation.invoke(currentState.toUserInformation()) },
                onSuccess = ::onSignUpSuccess,
                onError = ::onError
            )
        } else {
            updateValidationErrors(currentState)
            _state.update { it.copy(isLoading = false, isSignUpButtonClicked = false) }
        }
    }

    private fun onSignUpSuccess(unit:Unit) {
        _state.update { it.copy(isLoading = false) }
    }

    private fun onError(errorUiState: com.red_velvet.ui.base.ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    private fun updateValidationErrors(state: SignUpUIState) {
        _state.update {
            it.copy(
                usernameError = signUpValidation.validateUsername(state.username),
                firstNameError = signUpValidation.validateFirstName(state.firstName),
                lastNameError = signUpValidation.validateLastName(state.lastName),
                emailError = signUpValidation.validateEmail(state.email),
                passwordError = signUpValidation.validatePassword(state.password)
            )
        }
    }

    private fun SignUpUIState.toUserInformation(): com.red_velvet.domain.models.UserInformationEntity {
        return com.red_velvet.domain.models.UserInformationEntity(
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email,
        )
    }
}