package com.red_velvet.yumhub.ui.fnd_meal

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.usecases.recipes.SearchRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindYourMealViewModel @Inject constructor(
    private val searchRecipeUseCase: SearchRecipeUseCase
) : BaseViewModel<FindYourMealUiState, FindYourMaelUiEffect>(FindYourMealUiState()),
    FindYourMealInteractionListener {

    private val _searchInputFlow = MutableStateFlow("")
    private var debounceJob: Job? = null
    override fun onRecipeFindYourMealResultClicked(recipeId: Int) {
        viewModelScope.launch { _effect.emit(FindYourMaelUiEffect.ClickOnResultItem(recipeId)) }
    }



    @OptIn(FlowPreview::class)
    fun onSearchInputTextChanged(searchInput: CharSequence) {
        _state.update { it.copy(searchInput = searchInput.toString(), isLoading = true) }
        viewModelScope.launch {
            debounceJob?.cancel()
            debounceJob = viewModelScope.launch {
                _searchInputFlow
                    .debounce(700)
                    .flowOn(Dispatchers.Default)
                    .collect { onSearchForRecipes() }
            }

        }

    }


    private fun onSearchForRecipes() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            callee = {
                searchRecipeUseCase.invoke(
                    query = _state.value.searchInput,
                    sort = "",
                    sortDirection = ""
                )
            },
            ::onSearchForRecipesSuccess,
            ::onError)


    }

    private fun onSearchForRecipesSuccess(recipe: List<SearchRecipeEntity>) {
        val recipesUiState = recipe.map(SearchRecipeEntity::toFindYourMealResultUiState)
        _state.update {
            it.copy(
                isLoading = false,
                isResultIsEmpty = false,
                searchResult = recipesUiState,
                error = null
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


}