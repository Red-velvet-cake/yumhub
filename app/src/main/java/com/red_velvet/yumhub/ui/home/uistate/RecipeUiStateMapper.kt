package com.red_velvet.yumhub.ui.home.uistate

import com.red_velvet.yumhub.domain.models.recipes.Recipe


fun List<Recipe>.toUiState(): List<RecipeUiState> {
    return this.map {
        RecipeUiState(
            recipeImage = it.image,
            recipeTitle = it.title
        )
    }
}
