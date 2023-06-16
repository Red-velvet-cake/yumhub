package com.red_velvet.yumhub.ui.deit

import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.ui.search.SearchResultUIState
import com.red_velvet.yumhub.ui.search.formatMinutesAsDuration

fun SearchRecipeEntity.toDietResultMapper(): DietResultUIState {
    return DietResultUIState(
        id = id.orZero(),
        image = image.orEmpty(),
        title = title.orEmpty(),
    )
}