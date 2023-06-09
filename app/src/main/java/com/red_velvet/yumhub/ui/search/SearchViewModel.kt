package com.red_velvet.yumhub.ui.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import com.red_velvet.yumhub.domain.usecases.recipes.SearchRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.logging.Logger
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
                 onSuccess(result)
             }
         }catch (e:Exception){
             onError(e.message.toString())
         }
    }
     fun onSearch(){
        _uiState.update { it.copy(isLoading = true) }
        try {
            viewModelScope.launch {
                val result= searchRecipeUseCase.invoke(query=_uiState.value.searchInput , sort = "")
                Log.e("AYA",result.toString())
                onSuccess(result)
            }
        }catch (e:Exception){
            Log.e("AYA",e.message.toString())
            onError(e.message.toString())
        }
    }

    fun onClear(){
        _uiState.update { it.copy(isResultIsEmpty = false, searchInput = "") }
    }
    private fun onSuccess(recipes: List<RecipeInformation>){
      val searchResult=  recipes.map { it.toRecipeSearchResultMapper() }
        Log.e("AYA",searchResult.toString())
        _uiState.update { it.copy(searchResult = searchResult,
            isLoading = false,
            isResultIsEmpty =recipes.isEmpty() ) }
    }
    private fun onError(message: String) {
        val errors = _uiState.value.error.toMutableList()
        errors.add(message)
        _uiState.update { it.copy(error = errors, isLoading = false) }
    }


}