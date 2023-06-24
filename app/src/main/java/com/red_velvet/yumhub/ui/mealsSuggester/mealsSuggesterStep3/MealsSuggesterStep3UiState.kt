package com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.ui.base.BaseUiState

data class MealsSuggesterStep3UiState(
    val isLoading: Boolean? = true,
    val calories: Int? = 0,
    val meals:List<SuggestedMeals>?= emptyList()
):BaseUiState()
{
    data class SuggestedMeals(
        val imageUrl: String ,
        val title: String ,
    )
}
fun RecipeEntity.toSuggestedMeals():MealsSuggesterStep3UiState.SuggestedMeals{
    return MealsSuggesterStep3UiState.SuggestedMeals(
        imageUrl = imageUrl,
        title = title,
    )
}
fun List<RecipeEntity>.toSuggestedMeals():List<MealsSuggesterStep3UiState.SuggestedMeals>{
    return map { it.toSuggestedMeals() }
}
