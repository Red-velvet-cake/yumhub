package com.red_velvet.yumhub.ui.nutritionalValue
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.yumhub.domain.usecases.GuessNutritionUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NutritionalValueViewModel @Inject constructor(
    private val guessNutritionUseCase: GuessNutritionUseCase
) : BaseViewModel<NutritionalValueUIState, NutritionalValueUIEffect>(NutritionalValueUIState()),
    NutritionalValueInteractionListener {

    fun onInputSearchChange(newSearchInput: CharSequence) {
        _state.update { it.copy(textInput = newSearchInput.toString()) }
    }


    private fun validateSearchInput(input: String) = input.isNotEmpty()

    private fun onSearch() {
        viewModelScope.launch { _effect.emit(NutritionalValueUIEffect.HideKeyboard) }
        if (validateSearchInput(_state.value.textInput)) {
            onGetData()
        }  else {
            onInvalidInputs()
        }
    }

    private fun onInvalidInputs() {
        viewModelScope.launch { _effect.emit(NutritionalValueUIEffect.InvalidSearchInput) }
    }

    private fun onGetData() {
        tryToExecute(
            callee = { guessNutritionUseCase(title = _state.value.textInput) },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }
    private fun checkIfEmpty():Boolean{
        return _state.value.nutritionalValueResultUIState?.let { (calories, carbs, fat, protein) ->
            listOf(calories, carbs, fat, protein).all { it == 0.0 }
        } ?: false
    }

    private fun onSuccess(recipes: GuessNutritionEntity) {
        val searchResult = recipes.toNutritionalValueResultUIState()
        _state.update { it.copy(
            nutritionalValueResultUIState =
            searchResult, isLoading = false,
            textInput = "") }
        if(checkIfEmpty()){
            viewModelScope.launch { _effect.emit(NutritionalValueUIEffect.NoResultMessage) }
        }
    }

    private fun onError(errorUiState: ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    override fun doOnApplyRecipe() {
        _state.update { it.copy(isLoading = true,) }
        onSearch()
    }
}