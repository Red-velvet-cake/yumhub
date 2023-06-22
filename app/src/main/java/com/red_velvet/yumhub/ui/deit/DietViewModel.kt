package com.red_velvet.yumhub.ui.deit

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.usecases.GetDietRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DietViewModel @Inject constructor(
    private val getDietRecipe: GetDietRecipeUseCase,
) : BaseViewModel<DietUIState, DietUIEffect>(DietUIState()), DietRecipeInteractionListener {

    private val _uiState = MutableStateFlow(DietUIState())
    val uiState: StateFlow<DietUIState> = _uiState

    fun onSelectType(type: String) {
        Log.i("AYA", type)
        if (!ifSameFilterTypeSelected(type)) {
            _uiState.update { it.copy(isLoading = true, type = type) }
            onGetData()
        }
    }

    private fun onGetData() {
        tryToExecute(
            callee = { getDietRecipe(type = _uiState.value.type) },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    private fun ifSameFilterTypeSelected(type: String): Boolean {
        if (type == _uiState.value.type) {
            _uiState.update { it.copy(isLoading = false, type = "", dietResult = emptyList()) }
            return true
        }
        return false
    }

    private fun onSuccess(recipes: List<SearchRecipeEntity>) {
        val dietResult = recipes.map { it.toDietResultMapper() }
        Log.i("AYA", dietResult.toString())
        _uiState.update { it.copy(dietResult = dietResult, isLoading = false) }
    }

    private fun onError(errorUiState: ErrorUIState) {
        Log.i("AYA", errorUiState.toString())
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    override fun doOnRecipeClicked(recipeId: Int) {
        viewModelScope.launch { _effect.emit(DietUIEffect.ClickOnRecipe(recipeId)) }

    }
}