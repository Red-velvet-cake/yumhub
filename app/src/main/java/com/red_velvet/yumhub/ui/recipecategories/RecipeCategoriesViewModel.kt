package com.red_velvet.yumhub.ui.recipecategories

import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.domain.usecases.recipes.GetCategoriesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.home.toCategoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RecipeCategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : BaseViewModel<RecipeCategoriesUiState>(RecipeCategoriesUiState()) {

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

    private fun onGetRecipeCategoriesSuccess(categories: List<CategoryEntity>) {
        val recipeCategories = categories.toCategoryUiState()
        _state.update { it.copy(categoriesList = recipeCategories, isLoading = false) }
    }

    private fun onError(errorUiState: ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

}