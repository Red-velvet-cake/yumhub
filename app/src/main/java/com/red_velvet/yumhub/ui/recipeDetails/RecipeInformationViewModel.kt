package com.red_velvet.yumhub.ui.recipeDetails

import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import com.red_velvet.yumhub.domain.usecases.recipes.GetRecipeInformationUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RecipeInformationViewModel @Inject constructor(
    private val getRecipeInformationUseCase: GetRecipeInformationUseCase
) : BaseViewModel<RecipeInformationUIState>(RecipeInformationUIState()), DishTypeListener,
    IngredientsListener {

    init {
        getRecipeInformation(1038, false)
    }

    fun getRecipeInformation(id: Int, includeNutrition: Boolean) {
        tryToExecute(
            { getRecipeInformationUseCase.invoke(id, includeNutrition) },
            ::onSuccess,
            ::onError,
        )
    }

    private fun onSuccess(recipe: RecipeInformation) {
        _state.update { recipe.map().copy(isLoading = false) }
    }

    private fun onError(error: ErrorUIState) {
        _state.update { it.copy(isLoading = false, error = error) }
    }

    override fun dishClicked(dish: String) {
        TODO("Not yet implemented")
    }

    override fun ingredientClicked(id: Int) {
        TODO("Not yet implemented")
    }

}

