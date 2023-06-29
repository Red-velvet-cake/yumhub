package com.red_velvet.yumhub.ui.history

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.usecases.GetHistoryMealsUseCase
import com.red_velvet.yumhub.domain.usecases.RemoveHistoryRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getHistoryMeals: GetHistoryMealsUseCase,
    private val removeHistoryRecipeUseCase: RemoveHistoryRecipeUseCase,
) : BaseViewModel<HistoryUIState, HistoryUIEffect>(HistoryUIState()), HistoryInteractionListener {

    private val _uiState = MutableStateFlow(HistoryUIState())
    val uiState: StateFlow<HistoryUIState> = _uiState

    init {
        getHistoryItems()
    }

    private fun getHistoryItems() {
        tryToExecute(
            callee = getHistoryMeals::invoke, onSuccess = ::onSuccess, onError = ::onError
        )
    }

    private fun onSuccess(items: Flow<List<HistoryMealEntity>>) {
        viewModelScope.launch {
            items.collect { it ->
                val historyItems = it.map { it.toUiState() }
                _uiState.update {
                    it.copy(
                        historyItems = historyItems, isResultIsEmpty = historyItems.isEmpty()
                    )
                }
            }
        }
    }

    private fun onError(errorUiState: ErrorUIState) {
        _state.update { it.copy(error = errorUiState) }
    }

    override fun onHistoryItemClicked(itemId: Int) {
        viewModelScope.launch { _effect.emit(HistoryUIEffect.ClickOnItem(itemId)) }
    }

    override fun onHistoryRecipeRemoved(recipe: RecipeEntity) {
        viewModelScope.launch {
            removeHistoryRecipeUseCase(recipe)
            getHistoryItems()
        }
    }

}