package com.red_velvet.yumhub.ui.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.recipes.SearchRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.search.SearchUISate.SearchRecipeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRecipeUseCase: SearchRecipeUseCase
)  :BaseViewModel()  {
    private  val _uiState = MutableStateFlow(SearchRecipeUIState())
    val uiState : StateFlow<SearchRecipeUIState> = _uiState

     fun onInputSearchChange(newSearchInput:CharSequence){
        _uiState.update { it.copy(searchInput = newSearchInput.toString(),isLoading = true) }
         try {
             viewModelScope.launch {
                 val result=   searchRecipeUseCase.invoke(query=_uiState.value.searchInput , sort = "")
                 Log.d("AYA",result.toString())
                 _uiState.update { it.copy(searchResult = result,
                     isLoading = false,
                     isResultIsEmpty =result.isEmpty() ) }
             }
         }catch (e:Exception){
             onError(e.message.toString())
         }
    }
     fun onSearch(){
        _uiState.update { it.copy(isLoading = true) }
        try {
            viewModelScope.launch {
                val result=   searchRecipeUseCase.invoke(query=_uiState.value.searchInput , sort = "")
                Log.d("AYA",result.toString())
                _uiState.update { it.copy(searchResult = result,
                    isLoading = false,
                    isResultIsEmpty =result.isEmpty() ) }
            }
        }catch (e:Exception){
            onError(e.message.toString())
        }
    }

    private fun onError(message: String) {
        val errors = _uiState.value.error.toMutableList()
        errors.add(message)
        _uiState.update { it.copy(error = errors, isLoading = false) }
    }
}