package com.red_velvet.yumhub.ui.signUp

import android.util.Log
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
        _uiState.update { it.copy(username = username) }
    }

    fun onFirstNameChange(firstName: String) {
        _uiState.update { it.copy(firstName = firstName) }
    }

    fun onLastNameChange(lastName: String) {
        _uiState.update { it.copy(lastName = lastName) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onSignUpButtonClicked() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                saveUserInformation(_uiState.value.toUserInformation())
                _uiState.update { it.copy(isSignUpButtonClicked = true) }
            } catch (e: Exception) {
                _uiState.update { it.copy(errors = e.message.toString()) }
            }
        }
        Log.i("tag", _uiState.value.username)
        _uiState.update { it.copy(isLoading = false) }
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