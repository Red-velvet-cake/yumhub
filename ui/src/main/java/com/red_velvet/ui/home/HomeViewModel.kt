package com.red_velvet.ui.home

import androidx.lifecycle.viewModelScope
import com.red_velvet.domain.usecases.recipes.GetCategoriesUseCase
import com.red_velvet.domain.usecases.recipes.GetHealthyRecipesUseCase
import com.red_velvet.domain.usecases.recipes.GetPopularRecipesUseCase
import com.red_velvet.domain.usecases.recipes.GetQuickRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getQuickRecipesUseCase: GetQuickRecipesUseCase,
    private val getPopularRecipesUseCase: GetPopularRecipesUseCase,
    private val getHealthyRecipesUseCase: GetHealthyRecipesUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : com.red_velvet.ui.base.BaseViewModel<HomeUiState>(HomeUiState()), HomeInteractionListener {

    init {
        getCategories()
        getPopularRecipes()
        getHealthyRecipes()
        getQuickRecipes()
    }

    private fun getQuickRecipes() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            getQuickRecipesUseCase::invoke,
            onSuccess = ::onGetQuickRecipesSuccess,
            onError = ::onError
        )
    }

    private fun onGetQuickRecipesSuccess(quickRecipes: Flow<List<com.red_velvet.domain.models.recipes.QuickRecipeEntity>>) {
        viewModelScope.launch {
            quickRecipes.collect { items ->
                val quickRecipesState = items.toQuickRecipeUiState()
                _state.update {
                    it.copy(quickRecipesUiState = quickRecipesState, isLoading = false)
                }
            }
        }
    }

    private fun getPopularRecipes() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            getPopularRecipesUseCase::invoke,
            onSuccess = ::onGetPopularRecipeSuccess,
            onError = ::onError
        )
    }

    private fun onGetPopularRecipeSuccess(popularRecipes: Flow<List<com.red_velvet.domain.models.recipes.PopularRecipeEntity>>) {
        viewModelScope.launch {
            popularRecipes.collect { items ->
                val popularRecipesState = items.toPopularUiState()
                _state.update {
                    it.copy(
                        popularRecipesUiState = popularRecipesState,
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun getHealthyRecipes() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            getHealthyRecipesUseCase::invoke,
            onSuccess = ::onGetHealthyRecipeSuccess,
            onError = ::onError
        )
    }


    private fun onGetHealthyRecipeSuccess(healthyRecipes: Flow<List<com.red_velvet.domain.models.recipes.HealthyRecipeEntity>>) {
        viewModelScope.launch {
            healthyRecipes.collect { items ->
                val healthyRecipesState = items.toHealthyUiState()
                _state.update {
                    it.copy(
                        healthyRecipesUiState = healthyRecipesState,
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun getCategories() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            getCategoriesUseCase::invoke,
            onSuccess = ::onGetCategoriesSuccess,
            onError = ::onError
        )
    }

    private fun onGetCategoriesSuccess(recipesCategories: List<com.red_velvet.domain.models.recipes.CategoryEntity>) {
        val response = recipesCategories.toCategoryUiState()
        _state.update { it.copy(categoryRecipesUiState = response, isLoading = false) }
    }

    private fun onError(errorUiState: com.red_velvet.ui.base.ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    override fun doOnCategoryClicked(categoryTitle: String) {
    }

    override fun doOnPopularRecipeClicked(recipeId: Int) {
    }

}