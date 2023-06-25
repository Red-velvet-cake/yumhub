package com.red_velvet.yumhub.ui.favorites

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.usecases.GetFavoriteRecipesUseCase
import com.red_velvet.yumhub.domain.usecases.RemoveFavoriteRecipeUseCase
import com.red_velvet.yumhub.domain.usecases.SaveFavoriteRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoriteRecipes: GetFavoriteRecipesUseCase,
    private val removeFavoriteRecipe: RemoveFavoriteRecipeUseCase,
    private val saveFavoriteRecipe: SaveFavoriteRecipeUseCase
) : BaseViewModel<FavoritesUiState, FavoritesUiEffect>(FavoritesUiState()),
    FavoriteInteractionListener {
    init {
        getFavorites()
    }

    private fun getFavorites() {
        tryToExecute(
            getFavoriteRecipes::invoke,
            ::onGetFavoriteRecipesSuccess,
            ::onError
        )
    }

    private fun onGetFavoriteRecipesSuccess(recipes: List<RecipeEntity>) {
        _state.update { it.copy(favoritesRecipes = recipes.toUiState()) }
    }

    private fun onError(error: ErrorUIState) {
        _state.update { it.copy(error = error) }
    }

    override fun onFavoriteRecipeClicked(id: Int) {
        viewModelScope.launch { _effect.emit(FavoritesUiEffect.ClickOnRecipe(id)) }
    }

    override fun onFavoriteRecipeRemoved(recipe: RecipeEntity) {
        viewModelScope.launch {
            removeFavoriteRecipe(recipe)
            getFavorites()
        }
    }

    override fun onUndoRecipeRemoved(recipe: FavoritesUiState.RecipeUiState) {
        viewModelScope.launch {
            saveFavoriteRecipe(recipe.toEntity())
            getFavorites()
        }
    }

}