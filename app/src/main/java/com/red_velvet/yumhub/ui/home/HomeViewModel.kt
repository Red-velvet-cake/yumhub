package com.red_velvet.yumhub.ui.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.SliderItemEntity
import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.domain.usecases.GetHomeSliderImagesListUseCase
import com.red_velvet.yumhub.domain.usecases.GetUserNameUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetCategoriesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetHealthyRecipesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetPopularRecipesUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetQuickRecipesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.home.listeners.CategoryInteractionListener
import com.red_velvet.yumhub.ui.home.listeners.RecipeInteractionListener
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
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getUserNameUseCase: GetUserNameUseCase,
    private val getHomeSliderImagesListUseCase: GetHomeSliderImagesListUseCase
) : BaseViewModel<HomeUiState, HomeUIEffect>(HomeUiState()), CategoryInteractionListener,
    RecipeInteractionListener {

    init {
        getCategories()
        getPopularRecipes()
        getHealthyRecipes()
        getQuickRecipes()
        getUserName()
        getHomeSliderImageList()
    }

    private fun getUserName() {
        tryToExecute(
            callee = getUserNameUseCase::invoke,
            onSuccess = ::onGetUserNameSuccess,
            onError = ::onError
        )
    }

    private fun onGetUserNameSuccess(name: String) {
        _state.update {
            it.copy(name = name)
        }
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

    override fun doOnRecipeClicked(recipeId: Int) {
        viewModelScope.launch { _effect.emit(HomeUIEffect.ClickOnRecipe(recipeId)) }
    }

    override fun doOnClickSeeAllRecipes(type: Int) {
        viewModelScope.launch { _effect.emit(HomeUIEffect.ClickOnSeeAllHealthyRecipes(type)) }
    }

    private fun getHomeSliderImageList() {
        tryToExecute(
            getHomeSliderImagesListUseCase::invoke,
            onSuccess = ::onGetSliderImagesListSuccess,
            onError = ::onError
        )
    }

    private fun onGetSliderImagesListSuccess(sliderImageList: List<SliderItemEntity>) {
        val imageList = sliderImageList.toUiState()
        _state.update {
            it.copy(sliderImagesList = imageList, isLoading = false)
        }
    }

}