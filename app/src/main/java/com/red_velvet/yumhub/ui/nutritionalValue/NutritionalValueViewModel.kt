package com.red_velvet.yumhub.ui.nutritionalValue

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.usecases.GuessNutritionUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.search.SearchRecipeUIState
import com.red_velvet.yumhub.ui.search.toRecipeSearchResultMapper
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NutritionalValueViewModel @Inject constructor(
    private val guessNutritionUseCase: GuessNutritionUseCase
) :
    BaseViewModel<NutritionalValueUIState>(NutritionalValueUIState()) {
    private  val _uiState = MutableStateFlow(NutritionalValueUIState())
    val uiState : StateFlow<NutritionalValueUIState> = _uiState

    fun onInputSearchChange(newSearchInput:CharSequence){
        _uiState.update { it.copy(textInput = newSearchInput.toString()) }
    }
    fun onSearch(){
        if(_uiState.value.textInput.isEmpty()){
            return
        }
        _uiState.update { it.copy(isLoading = true) }
        onGetData()
    }
    private fun onGetData(){
        tryToExecute(
            callee = {
                guessNutritionUseCase.invoke(
                    title=_uiState.value.textInput)
            },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }
    private fun onSuccess(recipes: GuessNutritionEntity){
        val searchResult=  recipes.toNutritionalValueResultUIState()
        Log.i("AYA",searchResult.toString())
        _uiState.update { it.copy(
            nutritionalValueResultUIState = searchResult,
            isLoading = false,
        ) }
    }
    private fun onError(errorUiState: ErrorUIState) {
        Log.i("AYA",errorUiState.toString())
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }
}