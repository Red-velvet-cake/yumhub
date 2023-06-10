package com.red_velvet.yumhub.ui.home

import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity


fun List<PopularRecipeEntity>.toPopularUiState(): List<RecipeUiState> {
    return this.map {
        RecipeUiState(
            recipeImage = it.image,
            recipeTitle = it.title
        )
    }
}

fun List<HealthyRecipeEntity>.toHealthyUiState(): List<RecipeUiState> {
    return this.map {
        RecipeUiState(
            recipeImage = it.image,
            recipeTitle = it.title
        )
    }
}

fun List<QuickRecipeEntity>.toQuickRecipeUiState(): List<QuickRecipeUiState> {
    return this.map {
        QuickRecipeUiState(
            recipeImage = it.image,
            recipeTitle = it.title,
            cookingTime = it.cookingMinutes
        )
    }
}

fun List<CategoryEntity>.toCategoryUiState(): List<RecipeUiState> {
    return this.map {
        RecipeUiState(
            recipeImage = it.imageResource.toString(),
            recipeTitle = it.title
        )
    }
}
