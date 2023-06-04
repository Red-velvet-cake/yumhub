package com.red_velvet.yumhub.ui.home

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.Recipe
import com.red_velvet.yumhub.domain.usecases.recipes.GetHealthyRecipesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetPopularRecipesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetQuickRecipesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.home.uistate.HomeUiState
import com.red_velvet.yumhub.ui.home.uistate.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getQuickRecipesUseCase: GetQuickRecipesUseCase,
    private val getPopularRecipesUseCase: GetPopularRecipesUseCase,
    private val getHealthyRecipesUseCase: GetHealthyRecipesUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun getQuickRecipes() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                getQuickRecipesUseCase().map(List<Recipe>::toUiState).collect { items ->
                    _uiState.update { it.copy(quickRecipesUiState = items, isLoading = false) }
                }
            } catch (e: Exception) {
                onError(e.message.toString())
            }
        }
    }

    fun getPopularRecipes() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                getPopularRecipesUseCase().map(List<Recipe>::toUiState).collect { items ->
                    _uiState.update { it.copy(popularRecipesUiState = items, isLoading = false) }
                }
            } catch (e: Exception) {
                onError(e.message.toString())
            }
        }
    }

    fun getHealthyRecipes() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                getHealthyRecipesUseCase().map(List<Recipe>::toUiState).collect { items ->
                    _uiState.update { it.copy(healthyRecipesUiState = items, isLoading = false) }
                }
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

}