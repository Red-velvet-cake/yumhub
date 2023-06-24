package com.red_velvet.yumhub.ui.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.usecases.recipes.SearchRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRecipeUseCase: SearchRecipeUseCase,
)  :BaseViewModel<SearchRecipeUIState>(SearchRecipeUIState())  {
    private  val _uiState = MutableStateFlow(SearchRecipeUIState())
    val uiState : StateFlow<SearchRecipeUIState> = _uiState
    private var debounceJob: Job? = null
    private val _searchInputFlow = MutableStateFlow("")
    fun onInputSearchChange(newSearchInput:CharSequence){
        _uiState.update { it.copy(searchInput = newSearchInput.toString()) }
        _searchInputFlow.value = newSearchInput.toString()
        debounceJob?.cancel()
        debounceJob = viewModelScope.launch {
            _searchInputFlow
                .debounce(700)
                .collect { onGetData() }
        }
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
                searchResult = PagingData.empty()) }
            return true
        }
        return  false
    }
    fun onSelectSortDirection(sortDirection:String){
        _uiState.update { it.copy(isLoading = true, sortDirection = sortDirection) }
        onGetData()
    }
    private fun onGetData(){
        tryToExecutePaging(
            call = {
                searchRecipeUseCase.invoke(
                    query=_uiState.value.searchInput ,
                    sort = _uiState.value.sort,
                    sortDirection = _uiState.value.sortDirection).cachedIn(viewModelScope)
            },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    fun onClear(){
        _searchInputFlow.value =""
        _uiState.update { it.copy(
            sort = "",
            searchInput = "",
            isLoading = false,
            isResultIsEmpty =false ) }
    }

    private suspend fun onSuccess(recipes: PagingData<SearchRecipeEntity>){
        val searchResult=  recipes.map { it.toRecipeSearchResultMapper() }
        Log.i("AYA",searchResult.toString())

        _uiState.update { it.copy(
            searchResult = searchResult,
            isLoading = false,
            isResultIsEmpty = false ) }
    }
    private fun onError(errorUiState: ErrorUIState) {
        Log.i("AYA",errorUiState.toString())
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

}