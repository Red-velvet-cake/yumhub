package com.red_velvet.ui.category

import com.red_velvet.domain.models.recipes.RecipeEntity
import com.red_velvet.ui.home.RecipeUiState

fun List<RecipeEntity>.toUiState(): List<RecipeUiState> {
    return this.map {
        RecipeUiState(
            recipeTitle = it.title,
            recipeImage = it.imageUrl
        )
    }
}