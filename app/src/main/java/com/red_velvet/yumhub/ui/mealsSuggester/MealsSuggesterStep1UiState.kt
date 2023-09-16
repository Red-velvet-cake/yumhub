package com.red_velvet.yumhub.ui.mealsSuggester

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class MealsSuggesterStep1UiState(
    val isLoading: Boolean = true,
    val gender: String = "Male",
    val activityLevel: Int? = 2,
    val goal: String? = "Maintain Weight",
    val weight: Int? = null,
    val tall: Int? = null,
    val age: Int? = null,
    val calories: Int? = 0,
    val meals: List<SuggestedMeals>? = emptyList(),
    val error:ErrorUIState? = null,
    val recipeCalories: Int = 0,
) : BaseUiState {
    data class SuggestedMeals(
        val id: Int,
        val imageUrl: String = "",
        val title: String = "",
        val calories: Double = 0.0,
        var isSelectedRecipe: Boolean = false
    )
}
fun RecipeEntity.toSuggestedMeals(): MealsSuggesterStep1UiState.SuggestedMeals{
    return MealsSuggesterStep1UiState.SuggestedMeals(
        imageUrl = imageUrl,
        title = title,
        id = id,
        calories = calories
    )
}
fun List<RecipeEntity>.toSuggestedMeals():List<MealsSuggesterStep1UiState.SuggestedMeals>{
    return map { it.toSuggestedMeals() }
}
