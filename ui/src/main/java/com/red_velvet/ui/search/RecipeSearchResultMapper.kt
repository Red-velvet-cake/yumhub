package com.red_velvet.ui.search
import com.red_velvet.ui.util.orZero


fun formatMinutesAsDuration(minutes: Int): String {
    val hours = minutes / 60
    val remainingMinutes = minutes % 60

    return if (hours > 0) {
        "$hours H $remainingMinutes Min"
    } else {
        "$remainingMinutes Min"
    }
}

fun com.red_velvet.domain.models.recipes.SearchRecipeEntity.toRecipeSearchResultMapper(): SearchResultUIState {
    return SearchResultUIState(
        id = id.orZero(),
        image = image.orEmpty(),
        readyInMinutes =formatMinutesAsDuration(readyInMinutes.orZero()).orEmpty(),
        title = title.orEmpty(),
        ingredientNumber = analyzedInstructions
            .flatMap { instruction -> instruction.steps }
            .sumOf { step -> step.ingredientsEntity!!.size }
    )
}
