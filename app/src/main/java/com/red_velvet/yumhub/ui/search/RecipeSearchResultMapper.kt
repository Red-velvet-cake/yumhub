package com.red_velvet.yumhub.ui.search
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero

fun SearchRecipeEntity.toRecipeSearchResultMapper(): SearchResultUIState {
    return SearchResultUIState(
        id = id.orZero(),
        image = image.orEmpty(),
        readyInMinutes =readyInMinutes.orEmpty(),
        title = title.orEmpty(),
        ingredientNumber = analyzedInstructions
            .flatMap { instruction -> instruction.stepEntities }
            .sumOf { step -> step.ingredientsEntity.size }
    )
}
