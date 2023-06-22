package com.red_velvet.yumhub.ui.recipeDetails

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState


data class RecipeInformationUIState(
    val image: String = "",
    val title: String = "",
    val readyInMinutes: Int = 0,
    val servings: Int = 0,
    val description: String = "",
    val dishTypeUIState: List<DishTypeUIState> = emptyList(),
    val ingredientsUIState: List<IngredientsUIState> = emptyList(),
    val isLoading: Boolean = true,
    val error: ErrorUIState? = null
) : BaseUiState


data class DishTypeUIState(
    val dishType: String = "",
    val isDishTypeSelected: Boolean = false
)

data class IngredientsUIState(
    val image: String,
    val original: String
)

