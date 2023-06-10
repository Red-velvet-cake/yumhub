package com.red_velvet.yumhub.ui.search
import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructions
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipe
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero


fun formatMinutesAsDuration(minutes: Int): String {
    val hours = minutes / 60
    val remainingMinutes = minutes % 60

    return if (hours > 0) {
        "$hours H $remainingMinutes Min"
    } else {
        "$remainingMinutes Min"
    }
}

fun SearchRecipe.toRecipeSearchResultMapper(): SearchResultUIState {
    return SearchResultUIState(
        id = id.orZero(),
        image = image.orEmpty(),
        readyInMinutes =formatMinutesAsDuration(readyInMinutes.orZero()).orEmpty(),
        title = title.orEmpty(),
        ingredientNumber = analyzedInstructions
            .flatMap { instruction -> instruction.steps }
            .sumOf { step -> step.ingredients.size }
    )
}
