package com.red_velvet.yumhub.ui.search
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero


fun RecipeInformation.toRecipeSearchResultMapper(): SearchResultUIState {
    return SearchResultUIState(
        id = id.orZero(),
        image = image.orEmpty(),
        readyInMinutes = readyInMinutes.orZero(),
        title = title.orEmpty(),
        ingredientNumber = analyzedInstructions.sumBy { it.steps.sumBy { step -> step.ingredients.size } }
    )
}
