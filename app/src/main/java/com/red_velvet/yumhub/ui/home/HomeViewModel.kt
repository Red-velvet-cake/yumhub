package com.red_velvet.yumhub.ui.home

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.recipes.GetCategoriesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetHealthyRecipesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetPopularRecipesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetQuickRecipesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getQuickRecipesUseCase: GetQuickRecipesUseCase,
    private val getPopularRecipesUseCase: GetPopularRecipesUseCase,
    private val getHealthyRecipesUseCase: GetHealthyRecipesUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : BaseViewModel(), HomeInteractionListener {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        getCategories()
        getPopularRecipes()
        getHealthyRecipes()
        getQuickRecipes()
    }

    private fun getQuickRecipes() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val response = getQuickRecipesUseCase().toQuickRecipeUiState()
                _uiState.update { it.copy(quickRecipesUiState = response, isLoading = false) }
            } catch (e: Exception) {
                onError(e.message.toString())
            }
        }
    }

    private fun getPopularRecipes() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val response = getPopularRecipesUseCase().toPopularUiState()
                _uiState.update { it.copy(popularRecipesUiState = response, isLoading = false) }
            } catch (e: Exception) {
                onError(e.message.toString())
            }
        }
    }

    private fun getHealthyRecipes() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val response = getHealthyRecipesUseCase().toHealthyUiState()
                _uiState.update { it.copy(healthyRecipesUiState = response, isLoading = false) }
            } catch (e: Exception) {
                onError(e.message.toString())
            }
        }
    }

    private fun getCategories() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val response = getCategoriesUseCase().toCategoryUiState()
                _uiState.update { it.copy(categoryRecipesUiState = response, isLoading = false) }
            } catch (e: Exception) {
                onError(e.message.toString())
            }
        }
    }

    private fun onError(message: String) {
        val errors = _uiState.value.errors.toMutableList()
        errors.add(message)
        _uiState.update { it.copy(errors = errors, isLoading = false) }
    }

    override fun doOnCategoryClicked(categoryTitle: String) {
    }

    override fun doOnPopularRecipeClicked(recipeId: Int) {
    }

}