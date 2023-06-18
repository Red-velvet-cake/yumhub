package com.red_velvet.yumhub.ui.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.domain.usecases.recipes.GetCategoriesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetHealthyRecipesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetPopularRecipesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetQuickRecipesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.home.listeners.CategoryInteractionListener
import com.red_velvet.yumhub.ui.home.listeners.HealthyRecipeInteractionListener
import com.red_velvet.yumhub.ui.home.listeners.PopularRecipeInteractionListener
import com.red_velvet.yumhub.ui.home.listeners.QuickRecipeInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getQuickRecipesUseCase: GetQuickRecipesUseCase,
    private val getPopularRecipesUseCase: GetPopularRecipesUseCase,
    private val getHealthyRecipesUseCase: GetHealthyRecipesUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : BaseViewModel<HomeUiState>(HomeUiState()), CategoryInteractionListener,
    HealthyRecipeInteractionListener, QuickRecipeInteractionListener,
    PopularRecipeInteractionListener {

    private val _effect = MutableSharedFlow<HomeUIEffect>()
    val effect = _effect.asSharedFlow()

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

    private fun onGetQuickRecipesSuccess(quickRecipes: Flow<List<QuickRecipeEntity>>) {
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

    private fun onGetPopularRecipeSuccess(popularRecipes: Flow<List<PopularRecipeEntity>>) {
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


    private fun onGetHealthyRecipeSuccess(healthyRecipes: Flow<List<HealthyRecipeEntity>>) {
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

    private fun onGetCategoriesSuccess(recipesCategories: List<CategoryEntity>) {
        val response = recipesCategories.toCategoryUiState()
        _state.update { it.copy(categoryRecipesUiState = response, isLoading = false) }
    }

    private fun onError(errorUiState: ErrorUIState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    override fun doOnCategoryClicked(categoryTitle: String) {
        viewModelScope.launch { _effect.emit(HomeUIEffect.ClickOnCategory(categoryTitle)) }
    }

    override fun doOnClickSeeAllCategoryRecipes() {
        Log.d("alhams", "doOnClickSeeAllHealthyRecipes: ")
        viewModelScope.launch { _effect.emit(HomeUIEffect.ClickOnSeeAllCategories) }
    }

    override fun doOnPopularRecipeClicked(recipeId: Int) {
        viewModelScope.launch { _effect.emit(HomeUIEffect.ClickOnPopularRecipe(recipeId)) }
    }

    override fun doOnQuickRecipeClicked(recipeId: Int) {
        viewModelScope.launch { _effect.emit(HomeUIEffect.ClickOnQuickRecipe(recipeId)) }
    }

    override fun doOnClickSeeAllQuickRecipes(type: Int) {
        viewModelScope.launch { _effect.emit(HomeUIEffect.ClickOnSeeAllQuickRecipes(type)) }
    }

    override fun doOnClickSeeAllPopularRecipes(type: Int) {
        viewModelScope.launch { _effect.emit(HomeUIEffect.ClickOnSeeAllPopularRecipes(type)) }
    }

    override fun doOnHealthyRecipeClicked(recipeId: Int) {
        viewModelScope.launch { _effect.emit(HomeUIEffect.ClickOnHealthyRecipe(recipeId)) }
    }

    override fun doOnClickSeeAllHealthyRecipes(type: Int) {
        viewModelScope.launch { _effect.emit(HomeUIEffect.ClickOnSeeAllHealthyRecipes(type)) }
    }

}