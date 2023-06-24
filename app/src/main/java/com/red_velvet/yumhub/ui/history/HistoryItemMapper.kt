package com.red_velvet.yumhub.ui.history

import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero

fun HistoryMealEntity.toUiState(): HistoryItemUIState {
    return HistoryItemUIState(
        id = id.orZero(),
        title = title.orEmpty(),
        description = description.orEmpty(),
        image = image.orEmpty(),
    )
}
