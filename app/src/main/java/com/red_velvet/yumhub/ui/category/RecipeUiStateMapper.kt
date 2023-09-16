package com.red_velvet.yumhub.ui.category

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.ui.home.RecipeUiState

fun List<RecipeEntity>.toUiState(): List<RecipeUiState> {
    return this.map {
        RecipeUiState(
            id = it.id,
            recipeTitle = it.title,
            recipeImage = it.imageUrl
        )
    }
}