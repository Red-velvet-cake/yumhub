package com.red_velvet.yumhub.ui.history

import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.ui.favorites.FavoritesUiState
import com.red_velvet.yumhub.ui.favorites.toUiState

fun HistoryMealEntity.toUiState(): HistoryUIState.HistoryItemUIState {
    return HistoryUIState.HistoryItemUIState(
        id = id.orZero(),
        title = title.orEmpty(),
        description = description.orEmpty(),
        image = image.orEmpty(),
    )
}

fun List<RecipeEntity>.toUiState(): List<FavoritesUiState.RecipeUiState> {
    return map { it.toUiState() }
}

fun HistoryUIState.HistoryItemUIState.toEntity(): RecipeEntity {
    return RecipeEntity(
        id = id,
        title = title,
        imageUrl = image,
        overview = description
    )
}