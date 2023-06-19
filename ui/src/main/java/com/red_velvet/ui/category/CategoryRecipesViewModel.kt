package com.red_velvet.ui.category

import androidx.lifecycle.viewModelScope
import com.red_velvet.domain.usecases.recipes.GetSingleCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryRecipesViewModel @Inject constructor(
    private val getSingleCategoryUseCase: GetSingleCategoryUseCase
) : com.red_velvet.ui.base.BaseViewModel<CategoryRecipesUiState>(CategoryRecipesUiState()),
    RecipeInteractionListener {

    init {
        getRecipesByCategoryTitle()
    }

    private fun getRecipesByCategoryTitle() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            tryToExecute(
                getSingleCategoryUseCase::invoke,
                onSuccess = ::onGetRecipesSuccess,
                onError = ::onError
            )
        }
    }

    private fun onGetRecipesSuccess(recipes: List<com.red_velvet.domain.models.recipes.RecipeEntity>) {
        val recipesList = recipes.toUiState()
        _state.update { it.copy(recipesList = recipesList, isLoading = false) }
    }

    private fun onError(errorUIState: com.red_velvet.ui.base.ErrorUIState) {
        _state.update { it.copy(error = errorUIState, isLoading = false) }
    }
}