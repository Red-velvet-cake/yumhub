package com.red_velvet.yumhub.ui.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.usecases.SearchInputUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.SearchRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRecipeUseCase: SearchRecipeUseCase,
    private val searchInputUseCase: SearchInputUseCase
) : BaseViewModel<SearchRecipeUIState, SearchUIEffect>(SearchRecipeUIState()),
    SearchInteractionListener {


    private var debounceJob: Job? = null
    private var searchJob: Job? = null
    private val _searchInputFlow = MutableStateFlow("")

    fun onInputSearchChange(newSearchInput: CharSequence) {
        _state.update { it.copy(searchInput = newSearchInput.toString(), searchResult = emptyList()) }
        _searchInputFlow.value = newSearchInput.toString()
        debounceJob?.cancel()
        debounceJob = viewModelScope.launch {
            _searchInputFlow
                .debounce(700)
                .flowOn(Dispatchers.Default)
                .collect { onGetData() }
        }
    }

    fun onSelectFilterType(type: String) {
        if (!ifSameFilterTypeSelected(type)) {
            _state.update {
                it.copy(
                    isResultIsEmpty = false,
                    sort = type,
                    sortDirection = "asc",

                    )
            }
        }
        onGetData()
    }

    private fun ifSameFilterTypeSelected(type: String): Boolean {
        if (type == _state.value.sort) {
            _state.update {
                it.copy(
                    isLoading = false,
                    sort = "",
                    sortDirection = "",
                    isResultIsEmpty = false,
                    searchResult = emptyList()
                )
            }
            return true
        }
        return false
    }

    fun onSelectSortDirection(sortDirection: String) {
        _state.update { it.copy(sortDirection = sortDirection) }
        onGetData()
    }

    private fun onGetData() {
        if(searchInputUseCase(state.value.searchInput)){
            _state.update { it.copy(isLoading = true) }
            searchJob = tryToExecute(
                callee = {
                    searchRecipeUseCase.invoke(
                        query = _state.value.searchInput,
                        sort = _state.value.sort,
                        sortDirection = _state.value.sortDirection
                    )
                },
                onSuccess = ::onSuccess,
                onError = ::onError
            )
        }
    }

    fun onClear() {
        _searchInputFlow.value = ""
        _state.update {
            it.copy(
                searchResult = emptyList() ,
                sort = "",
                searchInput = "",
                isLoading = false,
                isResultIsEmpty = false
            )
        }
        searchJob?.cancel()
        Log.i("asdjhdsakdjsk",state.value.searchResult.toString())
    }

    private fun onSuccess(recipes: List<SearchRecipeEntity>) {
        val searchResult = recipes.map { it.toRecipeSearchResultMapper() }
        Log.i("AYA", searchResult.toString())

        _state.update {
            it.copy(
                searchResult = searchResult,
                isLoading = false,
                isResultIsEmpty = searchResult.isEmpty(),
                error= null
            )
        }
    }

    private fun onError(errorUiState: ErrorUIState) {
        _state.update {
            it.copy(
                isLoading = false,
                isResultIsEmpty = true,
                error = errorUiState,
                searchResult = emptyList()
            )
        }
    }

    override fun onRecipeSearchResultClicked(recipeId: Int) {
        viewModelScope.launch { _effect.emit(SearchUIEffect.ClickOnRecipe(recipeId)) }
    }

}