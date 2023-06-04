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
         Log.i("AYA",newSearchInput.toString())
        _uiState.update { it.copy(searchInput = newSearchInput.toString()) }
    }
    suspend fun onSearch(query:String){
        _uiState.update { it.copy(isLoading = true) }
        try {
            viewModelScope.launch {
                val result=   searchRecipeUseCase.invoke(query=query , sort = "")
                _uiState.update { it.copy(searchResult = result, isLoading = false) }
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
    suspend fun  onSelectFilterType(query:String){

    }

    suspend fun onClickRecipe(id:Int){

    }
}