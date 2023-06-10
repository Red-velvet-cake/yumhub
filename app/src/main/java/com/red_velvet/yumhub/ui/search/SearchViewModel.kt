package com.red_velvet.yumhub.ui.search

import com.red_velvet.yumhub.domain.models.recipes.SearchRecipe
import com.red_velvet.yumhub.domain.usecases.recipes.SearchRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRecipeUseCase: SearchRecipeUseCase,
)  :BaseViewModel<SearchRecipeUIState>(SearchRecipeUIState())  {
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
        ifSameFilterTypeSelected(type)
        _uiState.update { it.copy(
            isLoading = true,
            recipeFilter = type,
        ) }
        onGetData()
    }
    private fun ifSameFilterTypeSelected(type :String){
        if(type == _uiState.value.recipeFilter){
          _uiState.update { it.copy(
              isLoading = false,
              recipeFilter = "",
              isResultIsEmpty = false,
              searchResult = emptyList()) }
          return
      }
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
                    sort = _uiState.value.recipeFilter,
                    sortDirection = _uiState.value.sortDirection)
            },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    fun onClear(){
        _uiState.update {
        SearchRecipeUIState(
            isResultIsEmpty = false,
            searchInput = "",
            recipeFilter = "",
            sortDirection = ""
        ) }
    }

    private fun onSuccess(recipes: List<SearchRecipe>){
      val searchResult=  recipes.map { it.toRecipeSearchResultMapper() }
        _uiState.update { it.copy(searchResult = searchResult,
            isLoading = false,
            isResultIsEmpty =searchResult.isEmpty() ) }
    }
    private fun onError(errorUiState: ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

}