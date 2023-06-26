package com.red_velvet.yumhub.ui.mealsSuggester

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.ui.base.BaseUiState

data class MealsSuggesterStep1UiState(
    val isLoading: Boolean = true,
    val gender: String = "Male",
    val activityLevel: String = "",
    val goal: String? = "",
    val weight: Int? = 0,
    val tall: Int? = 0,
    val age: Int? = 0,
    val calories: Int? = 0,
    val meals: List<SuggestedMeals>? = emptyList()
) : BaseUiState {
    data class SuggestedMeals(
        val imageUrl: String,
        val title: String,
    )
}
fun RecipeEntity.toSuggestedMeals(): MealsSuggesterStep1UiState.SuggestedMeals{
    return MealsSuggesterStep1UiState.SuggestedMeals(
        imageUrl = imageUrl,
        title = title,
    )
}
fun List<RecipeEntity>.toSuggestedMeals():List<MealsSuggesterStep1UiState.SuggestedMeals>{
    return map { it.toSuggestedMeals() }
}
