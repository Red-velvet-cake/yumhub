package com.red_velvet.yumhub.ui.recipeDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformationEntity
import com.red_velvet.yumhub.domain.usecases.AddToHistoryMealsUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.GetRecipeInformationUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeInformationViewModel @Inject constructor(
    private val getRecipeInformationUseCase: GetRecipeInformationUseCase,
    stateHandle: SavedStateHandle
) : BaseViewModel<RecipeInformationUIState, RecipeDetailsUIEffect>(RecipeInformationUIState()),
    DishTypeListener, RecipeInformationInteractionListener, IngredientsListener {

    val args = RecipeInformationFragmentArgs.fromSavedStateHandle(stateHandle)

    init {
        getRecipeInformation(args.id)
    }

    private fun getRecipeInformation(id: Int) {
        tryToExecute(
            { getRecipeInformationUseCase.invoke(id) },
            ::onSuccess,
            ::onError,
        )
    }

    private fun onSuccess(recipe: RecipeInformationEntity) {
        _state.update { recipe.map().copy(isLoading = false) }
    }


    private fun onError(error: ErrorUIState) {
        _state.update { it.copy(isLoading = false, error = error) }
    }

    override fun onDishTypeClicked(dish: String) {
        viewModelScope.launch { _effect.emit(RecipeDetailsUIEffect.ClickOnDishType(dish)) }
    }

    override fun onIngredientClicked(id: Int) {
        viewModelScope.launch { _effect.emit(RecipeDetailsUIEffect.ClickOnGoToCookingSteps(id)) }
    }

    override fun onShowRecipeCookingStepsClicked(recipeId: Int) {
        viewModelScope.launch { _effect.emit(RecipeDetailsUIEffect.ClickOnGoToCookingSteps(recipeId)) }
    }

    override fun onAddToMealPlan(recipeId: Int) {
        viewModelScope.launch { _effect.emit(RecipeDetailsUIEffect.ClickAddToMealPlan(recipeId)) }
    }

}

