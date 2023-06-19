package com.red_velvet.ui.recipecategories

import com.red_velvet.domain.usecases.recipes.GetCategoriesUseCase
import com.red_velvet.ui.home.toCategoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RecipeCategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : com.red_velvet.ui.base.BaseViewModel<RecipeCategoriesUiState>(RecipeCategoriesUiState()) {

    init {
        getRecipeCategories()
    }

    private fun getRecipeCategories() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            getCategoriesUseCase::invoke,
            onSuccess = ::onGetRecipeCategoriesSuccess,
            onError = ::onError
        )
    }

    private fun onGetRecipeCategoriesSuccess(categories: List<com.red_velvet.domain.models.recipes.CategoryEntity>) {
        val recipeCategories = categories.toCategoryUiState()
        _state.update { it.copy(recipesList = recipeCategories, isLoading = false) }
    }

    private fun onError(errorUiState: com.red_velvet.ui.base.ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

}