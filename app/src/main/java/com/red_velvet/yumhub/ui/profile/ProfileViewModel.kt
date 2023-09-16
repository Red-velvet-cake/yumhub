package com.red_velvet.yumhub.ui.profile

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.GetUserNameUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUsername: GetUserNameUseCase
) : BaseViewModel<ProfileUiState, ProfileUiEffect>(ProfileUiState()), ProfileInteractionListener {

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

    override fun doOnSettingsClicked() {
        viewModelScope.launch { _effect.emit(ProfileUiEffect.ClickOnSettings) }
    }

    override fun doOnChatBotClicked() {
        viewModelScope.launch { _effect.emit(ProfileUiEffect.ClickOnChatBot) }
    }

    override fun doOnFavoritesClicked() {
        viewModelScope.launch { _effect.emit(ProfileUiEffect.ClickOnFavorites) }
    }

    override fun doOnHistoryClicked() {
        viewModelScope.launch { _effect.emit(ProfileUiEffect.ClickOnHistory) }
    }

    override fun doOnNutritionalValueClicked() {
        viewModelScope.launch { _effect.emit(ProfileUiEffect.ClickOnNutritionalValue) }
    }

    override fun doOnFoodSuggesterClicked() {
        viewModelScope.launch { _effect.emit(ProfileUiEffect.ClickOnFoodSuggester) }
    }

    override fun doOnMealTestClicked() {
        viewModelScope.launch { _effect.emit(ProfileUiEffect.ClickOnMealTest) }
    }

}