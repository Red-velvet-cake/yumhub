package com.red_velvet.yumhub.ui.ingredients

import com.red_velvet.yumhub.domain.models.recipes.ExtendedIngredientEntity
import com.red_velvet.yumhub.domain.usecases.GetIngredientsUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class IngredientsViewModel @Inject constructor(
    private val getIngredientsUseCase: GetIngredientsUseCase
) : BaseViewModel<IngredientsUIState, IngredientsUIEffect>(IngredientsUIState()),
    ExtendedIngredientsListener {

    init {
        getExtendedIngredients(1038, false)
    }

    private fun getExtendedIngredients(id: Int, includeNutrition: Boolean) {
        tryToExecute(
            { getIngredientsUseCase.invoke(id, includeNutrition) },
            ::onSuccess,
            ::onError,
        )
    }

    private fun onSuccess(ingredients: List<ExtendedIngredientEntity>) {
        _state.update {
            it.copy(isLoading = false, resultIngredient = ingredients.map { extendedIngredient ->
                extendedIngredient.toExtendedIngredientsUIState()
            })
        }
    }

    private fun onError(error: ErrorUIState) {
        _state.update { it.copy(isLoading = false, error = error) }
    }

    override fun ingredientClicked(id: Int) {
        TODO("Not yet implemented")
    }


}
