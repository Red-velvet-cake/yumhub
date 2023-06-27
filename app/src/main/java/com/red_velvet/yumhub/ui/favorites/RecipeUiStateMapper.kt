package com.red_velvet.yumhub.ui.favorites

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity

fun RecipeEntity.toUiState(): FavoritesUiState.RecipeUiState {
    return FavoritesUiState.RecipeUiState(
        id = id,
        title = title,
        image = imageUrl,
        overview = overview
    )
}

fun List<RecipeEntity>.toUiState(): List<FavoritesUiState.RecipeUiState> {
    return map { it.toUiState() }
}

fun FavoritesUiState.RecipeUiState.toEntity(): RecipeEntity {
    return RecipeEntity(
        id = id,
        title = title,
        imageUrl = image,
        overview = overview
    )
}