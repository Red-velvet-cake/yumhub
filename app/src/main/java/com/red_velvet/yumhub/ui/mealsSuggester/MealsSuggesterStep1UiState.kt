package com.red_velvet.yumhub.ui.mealsSuggester

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class MealsSuggesterStep1UiState(
    val isLoading: Boolean = true,
    val gender: String = "Male",
    val activityLevel: Int? = 0,
    val goal: String? = "",
    val weight: Int? = 0,
    val tall: Int? = 0,
    val age: Int? = 0,
    val calories: Int? = 0,
    val meals: List<SuggestedMeals>? = emptyList(),
    val error:ErrorUIState? = null
) : BaseUiState {
    data class SuggestedMeals(
        val id: Int,
        val imageUrl: String = "",
        val title: String = "",
    )
}
fun RecipeEntity.toSuggestedMeals(): MealsSuggesterStep1UiState.SuggestedMeals{
    return MealsSuggesterStep1UiState.SuggestedMeals(
        imageUrl = imageUrl,
        title = title,
        id = id
    )
}
fun List<RecipeEntity>.toSuggestedMeals():List<MealsSuggesterStep1UiState.SuggestedMeals>{
    return map { it.toSuggestedMeals() }
}
