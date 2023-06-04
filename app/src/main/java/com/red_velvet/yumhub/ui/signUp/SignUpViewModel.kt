package com.red_velvet.yumhub.ui.signUp

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.UserInformation
import com.red_velvet.yumhub.domain.usecases.SaveUserNameAndHashUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val saveUserInformation: SaveUserNameAndHashUseCase,
) : BaseViewModel() {

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
        if (isFormValid(currentState)) {
            _uiState.update { it.copy(isLoading = true) }
            viewModelScope.launch {
                try {
                    saveUserInformation(currentState.toUserInformation())
                    _uiState.update { it.copy(isSignUpButtonClicked = true) }
                } catch (e: Exception) {
                    _uiState.update { it.copy(errors = e.message.toString()) }
                } finally {
                    _uiState.update { it.copy(isLoading = false) }
                }
            }
        } else {
            updateValidationErrors(currentState)
        }
    }


    private fun isFormValid(state: SignUpUIState): Boolean {
        return state.username.isNotBlank() &&
                state.firstName.isNotBlank() &&
                state.lastName.isNotBlank() &&
                state.email.isNotBlank() &&
                state.password.isNotBlank()
    }

    private fun updateValidationErrors(state: SignUpUIState) {
        _uiState.update {
            it.copy(
                usernameError = if (state.username.isBlank()) "Username is required" else null,
                firstNameError = if (state.firstName.isBlank()) "First name is required" else null,
                lastNameError = if (state.lastName.isBlank()) "Last name is required" else null,
                emailError = if (state.email.isBlank()) "Email is required" else null,
                passwordError = if (state.password.isBlank()) "Password is required" else null
            )
        }
    }

    private fun SignUpUIState.toUserInformation(): UserInformation {
        return UserInformation(
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email,
        )
    }
}