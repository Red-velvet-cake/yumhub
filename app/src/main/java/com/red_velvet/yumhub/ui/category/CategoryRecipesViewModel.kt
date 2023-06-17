package com.red_velvet.yumhub.ui.category

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.usecases.recipes.GetSingleCategoryUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryRecipesViewModel @Inject constructor(
    private val getSingleCategoryUseCase: GetSingleCategoryUseCase,
) : BaseViewModel<CategoryRecipesUiState>(CategoryRecipesUiState()), RecipeInteractionListener {


    fun getRecipesByCategoryTitle(type: String?, sort: String?) {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            tryToExecute(
                { getSingleCategoryUseCase(type, sort) },
                onSuccess = ::onGetRecipesSuccess,
                onError = ::onError
            )
        }
    }

    private fun onGetRecipesSuccess(recipes: List<RecipeEntity>) {
        val recipesList = recipes.toUiState()
        _state.update { it.copy(recipesList = recipesList, isLoading = false) }
    }

    private fun onError(errorUIState: ErrorUIState) {
        _state.update { it.copy(error = errorUIState, isLoading = false) }
    }
}