package com.red_velvet.ui.search

import android.util.Log
import com.red_velvet.domain.usecases.recipes.SearchRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRecipeUseCase: SearchRecipeUseCase,
)  : com.red_velvet.ui.base.BaseViewModel<SearchRecipeUIState>(SearchRecipeUIState())  {
    private  val _uiState = MutableStateFlow(SearchRecipeUIState())
    val uiState : StateFlow<SearchRecipeUIState> = _uiState

    fun onInputSearchChange(newSearchInput:CharSequence){
        _uiState.update { it.copy(searchInput = newSearchInput.toString()) }
    }
    fun onSearch(){
        _uiState.update { it.copy(isLoading = true) }
        onGetData()
    }
    fun onSelectFilterType(type:String){
       if(!ifSameFilterTypeSelected(type)){
           _uiState.update { it.copy(
               isLoading = true,
               isResultIsEmpty = false,
               sort = type,
           ) }
           onGetData()
       }
    }
    private fun ifSameFilterTypeSelected(type :String):Boolean{
        if(type == _uiState.value.sort){
            _uiState.update { it.copy(
                isLoading = false,
                sort = "",
                isResultIsEmpty = false,
                searchResult = emptyList()) }
            return true
        }
        return  false
    }
    fun onSelectSortDirection(sortDirection:String){
        _uiState.update { it.copy(isLoading = true, sortDirection = sortDirection) }
        onGetData()
    }
    private fun onGetData(){
        tryToExecute(
            callee = {
                searchRecipeUseCase.invoke(
                    query=_uiState.value.searchInput ,
                    sort = _uiState.value.sort,
                    sortDirection = _uiState.value.sortDirection)
            },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    fun onClear(){
        _uiState.update { it.copy(
            sort = "",
            searchInput = "",
            isLoading = false,
            isResultIsEmpty =false ) }
    }

    private fun onSuccess(recipes: List<com.red_velvet.domain.models.recipes.SearchRecipeEntity>){
        val searchResult=  recipes.map { it.toRecipeSearchResultMapper() }
        Log.i("AYA",searchResult.toString())

        _uiState.update { it.copy(
            searchResult = searchResult,
            isLoading = false,
            isResultIsEmpty =searchResult.isEmpty() ) }
    }
    private fun onError(errorUiState: com.red_velvet.ui.base.ErrorUIState) {
        Log.i("AYA",errorUiState.toString())
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

}